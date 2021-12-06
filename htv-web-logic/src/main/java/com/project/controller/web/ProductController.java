/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.controller.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.project.command.ProductCommand;
import com.project.core.dto.ProductDTO;
import com.project.core.web.common.WebConstant;
import com.project.core.web.utils.FormUtil;
import com.project.core.web.utils.RequestUtil;
import com.project.core.web.utils.SingletonServiceUtil;

import org.apache.commons.lang.StringUtils;

/**
 *
 * @author 19110
 */
@WebServlet(urlPatterns = {"/home-phone.html","/product-phone-detail.html"})
public class ProductController extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductCommand command = FormUtil.populate(ProductCommand.class, request);
        if (request.getParameter("productId") != null) {
            String productStr = request.getParameter("productId");
            ProductDTO exitsProduct = SingletonServiceUtil.getProductServiceInstance().findById(Integer.parseInt(productStr));
            command.setPojo(exitsProduct);
            request.setAttribute(WebConstant.FORM_ITEM, command);
            RequestDispatcher rd = request.getRequestDispatcher("/views/product/detail.jsp");
            rd.forward(request, response);
        } else {
            executeSearchProduct(request, command);
            request.setAttribute(WebConstant.LIST_ITEMS, command);
            RequestDispatcher rd = request.getRequestDispatcher("/views/product/phone.jsp");
            rd.forward(request, response);
        }
    }

    private void executeSearchProduct(HttpServletRequest request, ProductCommand command) {
        Map<String, Object> properties = buildMapProperties(command);
        command.setMaxPageItems(10);
        RequestUtil.initSearchBeanManual(command);
        Object[] objects = SingletonServiceUtil.getProductServiceInstance().findByProperty(properties, command.getSortExpression(), command.getSortDirection(),command.getFirstItem(),command.getMaxPageItems());
        command.setListResult((List<ProductDTO>) objects[1]);
        command.setTotalItems(Integer.parseInt(objects[0].toString()));
        command.setTotalPages((int) Math.ceil((double) command.getTotalItems() / command.getMaxPageItems()));
    }

    private Map<String,Object> buildMapProperties(ProductCommand command) {
        Map<String, Object> properties = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(command.getPojo().getProductName())) {
            properties.put("productName", command.getPojo().getProductName());
        }
        return properties;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
