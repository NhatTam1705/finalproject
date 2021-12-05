/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.project.command.ProductCommand;
import com.project.core.common.utils.ExcelPoiUtil;
import com.project.core.common.utils.SessionUtil;
import com.project.core.common.utils.UploadUtil;
import com.project.core.dto.DiscountDTO;
import com.project.core.dto.ManuFacterDTO;
import com.project.core.dto.ProductDTO;
import com.project.core.web.common.WebConstant;
import com.project.core.web.utils.FormUtil;
import com.project.core.web.utils.RequestUtil;
import com.project.core.web.utils.SingletonServiceUtil;
import com.project.core.web.utils.WebCommonUtil;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author 19110
 */
@WebServlet(urlPatterns = {"/admin-product-list.html", "/admin-product-edit.html"})
public class ProductController extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductCommand command = FormUtil.populate(ProductCommand.class, request);
        ProductDTO pojo = command.getPojo();
        if (command.getUrlType() != null && command.getUrlType().equals(WebConstant.URL_LIST)) {
            if (command.getCrudaction() != null && command.getCrudaction().equals(WebConstant.REDIRECT_DELETE)) {
                List<Integer> ids = new ArrayList<Integer>();
                for (String item: command.getCheckList()) {
                    ids.add(Integer.parseInt(item));
                }
                Integer result = SingletonServiceUtil.getProductServiceInstance().delete(ids);
                if (result != ids.size()) {
                    command.setCrudaction(WebConstant.REDIRECT_ERROR);
                }
            }
            executeSearchProduct(request, command);
            if (command.getCrudaction() != null) {
                Map<String, String> mapMessage = buidMapRedirectMessage();
                WebCommonUtil.addRedirectMessage(request, command.getCrudaction(), mapMessage);
            }
            request.setAttribute(WebConstant.LIST_ITEMS, command);
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/product/list.jsp");
            rd.forward(request, response);
        } else if (command.getUrlType() != null && command.getUrlType().equals(WebConstant.URL_EDIT)) {
            if (pojo != null && pojo.getProductId() != null) {
                command.setPojo(SingletonServiceUtil.getProductServiceInstance().findById(pojo.getProductId()));
            }
            command.setDiscounts(SingletonServiceUtil.getDiscountServiceInstance().findAll());
            command.setManuFacters(SingletonServiceUtil.getManuFacterServiceInstance().findAll());
            request.setAttribute(WebConstant.FORM_ITEM, command);
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/product/edit.jsp");
            rd.forward(request, response);
        }
    }

    private void executeSearchProduct(HttpServletRequest request, ProductCommand command) {
        Map<String, Object> properties = buildMapProperties(command);
        RequestUtil.initSearchBean(request, command);
        Object[] objects = SingletonServiceUtil.getProductServiceInstance().findByProperty(properties, command.getSortExpression(), command.getSortDirection(),command.getFirstItem(),command.getMaxPageItems());
        command.setListResult((List<ProductDTO>) objects[1]);
        command.setTotalItems(Integer.parseInt(objects[0].toString()));
    }

    private Map<String,Object> buildMapProperties(ProductCommand command) {
        Map<String, Object> properties = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(command.getPojo().getProductName())) {
            properties.put("productName", command.getPojo().getProductName());
        }
        return properties;
    }

    private Map<String, String> buidMapRedirectMessage() {
        Map<String, String> mapMessage = new HashMap<String, String>();
        mapMessage.put(WebConstant.REDIRECT_INSERT, "Add Product Success");
        mapMessage.put(WebConstant.REDIRECT_UPDATE, "Update Product Success");
        mapMessage.put(WebConstant.REDIRECT_DELETE, "Delete Product Success");
        mapMessage.put(WebConstant.REDIRECT_IMPORT, "Import Product Success");
        mapMessage.put(WebConstant.REDIRECT_ERROR, "An error occurred");
        return mapMessage;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                ProductCommand command = new ProductCommand();
                UploadUtil uploadUtil = new UploadUtil();
                Set<String> valueTitle = buildSetValueProduct();
                Object[] objects = uploadUtil.writeOrUpdateFile(request, valueTitle, "img");
                boolean checkStatusUploadImage = (Boolean) objects[0];
                if (!checkStatusUploadImage) {
                    response.sendRedirect("/htv-web/admin-admin-list.html?urlType=url_list&&crudaction=redirect_error");
                } else {
                    ProductDTO dto = command.getPojo();
                    if (StringUtils.isNotBlank(objects[2].toString())) {
                        dto.setImage(objects[2].toString());
                    }
                    Map<String, String> mapValue = (Map<String, String>) objects[3];
                    dto = returnValueOfDTO(dto, mapValue);
                    if (dto != null) {
                        if (dto.getProductId() != null) {
                            ProductDTO productDTO = SingletonServiceUtil.getProductServiceInstance().findByProductId("productId", dto.getProductId());
                            if (dto.getImage() == null) {
                                dto.setImage(productDTO.getImage());
                            }
                            dto.setCreatedDate(productDTO.getCreatedDate());
                            ProductDTO result = SingletonServiceUtil.getProductServiceInstance().updateProduct(dto);
                            if (result != null) {
                                response.sendRedirect("/htv-web/admin-product-list.html?urlType=url_list&&crudaction=redirect_update");
                            } else {
                                response.sendRedirect("/htv-web/admin-product-list.html?urlType=url_list&&crudaction=redirect_error");
                            }
                        } else {
                            try {
                                SingletonServiceUtil.getProductServiceInstance().saveProduct(dto);
                                response.sendRedirect("/htv-web/admin-product-list.html?urlType=url_list&&crudaction=redirect_insert");
                            } catch (ConstraintViolationException e) {
                                log.error(e.getMessage(), e);
                                response.sendRedirect("/htv-web/admin-product-list.html?urlType=url_list&crudaction=redirect_error");
                            }
                        }
                    }
                }
    }

    private ProductDTO returnValueOfDTO(ProductDTO dto, Map<String, String> mapValue) {
        for (Map.Entry<String, String> item: mapValue.entrySet()) {
            if (item.getKey().equals("pojo.productName")) {
                dto.setProductName(item.getValue());
            } else if (item.getKey().equals("pojo.description")) {
                dto.setDescription(item.getValue());
            } else if (item.getKey().equals("pojo.quantityLeft")) {
                dto.setQuantityLeft(item.getValue());
            } else if (item.getKey().equals("pojo.price")) {
                dto.setPrice(item.getValue());
            } else if (item.getKey().equals("pojo.style")) {
                dto.setStyle(item.getValue());
            } else if (item.getKey().equals("pojo.rom")) {
                dto.setRom(item.getValue());
            } else if (item.getKey().equals("pojo.ram")) {
                dto.setRam(item.getValue());
            } else if (item.getKey().equals("discountId")) {
                DiscountDTO discountDTO = SingletonServiceUtil.getDiscountServiceInstance().findById(Integer.parseInt(item.getValue().toString()));
                dto.setDiscountDTO(discountDTO);
            } else if (item.getKey().equals("manufacterId")) {
                ManuFacterDTO manuFacterDTO = SingletonServiceUtil.getManuFacterServiceInstance().findById(Integer.parseInt(item.getValue().toString()));
                dto.setManuFacterDTO(manuFacterDTO);
            } else if (item.getKey().equals("pojo.productId")) {
                dto.setProductId(Integer.parseInt(item.getValue().toString()));
            }
        }
        return dto;
    }
    private Set<String> buildSetValueProduct() {
        Set<String> returnValue = new HashSet<String>();
        returnValue.add("pojo.productName");
        returnValue.add("pojo.description");
        returnValue.add("pojo.quantityLeft");
        returnValue.add("pojo.price");
        returnValue.add("pojo.style");
        returnValue.add("pojo.rom");
        returnValue.add("pojo.ram");
        returnValue.add("discountId");
        returnValue.add("manufacterId");
        returnValue.add("pojo.productId");
        return returnValue;
    }
}
