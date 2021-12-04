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
import com.project.core.dto.ProductImportDTO;
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

/**
 *
 * @author 19110
 */
@WebServlet(urlPatterns = {"/admin-product-list.html", "/ajax-admin-product-edit.html", "/admin-product-import.html",
                                "/admin-product-import-validate.html"})
public class ProductController extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
    private final String SHOW_IMPORT_PRODUCT = "show_import_product";
    private final String READ_EXCEL = "read_excel";
    private final String VALIDATE_IMPORT = "validate_import";
    private final String LIST_PRODUCT_IMPORT = "list_product_import";
    private final String IMPORT_DATA = "import_data";
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
        } else if (command.getUrlType() != null && command.getUrlType().equals(SHOW_IMPORT_PRODUCT)) {
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/product/importproduct.jsp");
            rd.forward(request, response);
        } else if (command.getUrlType() != null && command.getUrlType().equals(VALIDATE_IMPORT)) {
            List<ProductImportDTO> productImportDTOS = (List<ProductImportDTO>) SessionUtil.getInstance().getValue(request, LIST_PRODUCT_IMPORT);
            command.setProductImportDTOS(returnListProductImport(command, productImportDTOS, request));
            request.setAttribute(WebConstant.LIST_ITEMS, command);
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/product/importproduct.jsp");
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

    private List<ProductImportDTO> returnListProductImport(ProductCommand command, List<ProductImportDTO> productImportDTOS, HttpServletRequest request) {
        command.setMaxPageItems(3);
    RequestUtil.initSearchBean(request, command);
    command.setTotalItems(productImportDTOS.size());
    int fromIndex = command.getFirstItem();
    if (fromIndex > command.getTotalItems()) {
        fromIndex = 0;
        command.setFirstItem(0);
    }
    int toIndex = command.getFirstItem() + command.getMaxPageItems();
    if (productImportDTOS.size() > 0) {
        if (toIndex > productImportDTOS.size()) {
            toIndex = productImportDTOS.size();
        }
    }
    return productImportDTOS.subList(fromIndex, toIndex);
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
        UploadUtil uploadUtil = new UploadUtil();
        Set<String> value = new HashSet<String>();
        value.add("urlType");
        Object[] objects = uploadUtil.writeOrUpdateFile(request, value, "excel");
        try {
            ProductCommand command = FormUtil.populate(ProductCommand.class, request);
            ProductDTO pojo = command.getPojo();
            if (command.getUrlType() != null && command.getUrlType().equals(WebConstant.URL_EDIT)) {
                if (command.getCrudaction() != null && command.getCrudaction().equals(WebConstant.INSERT_UPDATE)) {
                    DiscountDTO discountDTO = new DiscountDTO();
                    discountDTO.setDiscountId(command.getDiscountId());
                    pojo.setDiscountDTO(discountDTO);
                    ManuFacterDTO manuFacterDTO = new ManuFacterDTO();
                    manuFacterDTO.setManufacterId(command.getManuFacterId());
                    pojo.setManuFacterDTO(manuFacterDTO);
                    if (pojo != null && pojo.getProductId() != null) {
                        SingletonServiceUtil.getProductServiceInstance().updateProduct(pojo);
                        request.setAttribute(WebConstant.MESSAGE_RESPONSE, WebConstant.REDIRECT_UPDATE);
                    } else {
                        SingletonServiceUtil.getProductServiceInstance().saveProduct(pojo);
                        request.setAttribute(WebConstant.MESSAGE_RESPONSE, WebConstant.REDIRECT_INSERT);
                    }
                }
                RequestDispatcher rd = request.getRequestDispatcher("/views/admin/product/edit.jsp");
                rd.forward(request, response);
            }
            if (objects != null) {
                String urlType = null;
                Map<String, String> mapValue = (Map<String, String>) objects[3];
                for (Map.Entry<String, String> item: mapValue.entrySet()) {
                    if (item.getKey().equals("urlType")) {
                        urlType = item.getValue();
                    }
                }
                if (urlType != null && urlType.equals(READ_EXCEL)) {
                    String fileLocation = objects[1].toString();
                    String fileName = objects[2].toString();
                    List<ProductImportDTO> excelValues = returnValueFromExcel(fileName, fileLocation);
                    validateData(excelValues);
                    SessionUtil.getInstance().putValue(request, LIST_PRODUCT_IMPORT, excelValues);
                    response.sendRedirect("/htv-web/admin-product-import-validate.html?urlType=validate_import");
                }
            }
            if (command.getUrlType() != null && command.getUrlType().equals(IMPORT_DATA)) {
                List<ProductImportDTO> productImportDTOS = (List<ProductImportDTO>) SessionUtil.getInstance().getValue(request, LIST_PRODUCT_IMPORT);
                SingletonServiceUtil.getProductServiceInstance().saveProductImport(productImportDTOS);
                SessionUtil.getInstance().remove(request, LIST_PRODUCT_IMPORT);
                response.sendRedirect("/htv-web/admin-product-list.html?urlType=url_list");               
                request.setAttribute(WebConstant.MESSAGE_RESPONSE, WebConstant.REDIRECT_IMPORT);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            request.setAttribute(WebConstant.MESSAGE_RESPONSE, WebConstant.REDIRECT_ERROR);
        }
    }

    private List<ProductImportDTO> returnValueFromExcel(String fileName, String fileLocation) throws IOException{
        Workbook workbook = ExcelPoiUtil.getWorkBook(fileName, fileLocation);
        Sheet sheet = workbook.getSheetAt(0);
        List<ProductImportDTO> excelValues = new ArrayList<ProductImportDTO>();
                    for (int i=1; i <= sheet.getLastRowNum(); i++) {
                        Row row = sheet.getRow(i);
                        ProductImportDTO productImportDTO = readDataFromExcel(row);
                        excelValues.add(productImportDTO);
                    }
        return excelValues;
    }

    private ProductImportDTO readDataFromExcel(Row row) {
        ProductImportDTO productImportDTO = new ProductImportDTO();
        productImportDTO.setProductName(ExcelPoiUtil.getCellValue(row.getCell(0)));
        productImportDTO.setDescription(ExcelPoiUtil.getCellValue(row.getCell(1)));
        productImportDTO.setQuantityLeft(ExcelPoiUtil.getCellValue(row.getCell(2)));
        productImportDTO.setManuFacter(ExcelPoiUtil.getCellValue(row.getCell(3)));
        productImportDTO.setPrice(ExcelPoiUtil.getCellValue(row.getCell(4)));
        productImportDTO.setStyle(ExcelPoiUtil.getCellValue(row.getCell(5)));
        productImportDTO.setRom(ExcelPoiUtil.getCellValue(row.getCell(6)));
        productImportDTO.setRam(ExcelPoiUtil.getCellValue(row.getCell(7)));
        productImportDTO.setDiscount(ExcelPoiUtil.getCellValue(row.getCell(8)));
        return productImportDTO;
    }

    private void validateData(List<ProductImportDTO> excelValues) {
        Set<String> stringSet = new HashSet<String>();
        for (ProductImportDTO item: excelValues) {
            validateRequireField(item);
            validateDuplicate(item, stringSet);
        }
        SingletonServiceUtil.getProductServiceInstance().validateImportProduct(excelValues);
    }

    private void validateDuplicate(ProductImportDTO item, Set<String> stringSet) {
        String message = item.getError();
        if (!stringSet.contains(item.getProductName())) {
            stringSet.add(item.getProductName());
        } else {
            if (item.isValid()) {
                message += "<br/>";
                message = "Product is duplicate";
            }
        }
        if (StringUtils.isNotBlank(message)) {
            item.setValid(false);
            item.setError(message.substring(5));
        }
    }

    private void validateRequireField(ProductImportDTO item) {
        String message = "";
        if (StringUtils.isBlank(item.getProductName())) {
            message += "<br/>";
            message += "Product is not blank.";
        }
        if (StringUtils.isBlank(item.getManuFacter())) {
            message += "<br/>";
            message += "Manufacter type is not blank.";
        }
        if (StringUtils.isBlank(item.getDiscount())) {
            message += "<br/>";
            message += "Discount type is not blank.";
        }
        if (StringUtils.isNotBlank(message)) {
            item.setValid(false);
        }
        item.setError(message);
    }
}
