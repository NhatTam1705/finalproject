/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.project.command.OrderCommand;
import com.project.core.dto.OrderItemDTO;
import com.project.core.web.common.WebConstant;
import com.project.core.web.utils.FormUtil;
import com.project.core.web.utils.RequestUtil;
import com.project.core.web.utils.SingletonServiceUtil;
import com.project.core.web.utils.WebCommonUtil;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author 19110
 */
@WebServlet(urlPatterns = {"/admin-order-list.html", "/admin-order-edit.html"})
public class OrderController extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OrderCommand command = FormUtil.populate(OrderCommand.class, request);
        OrderItemDTO pojo = command.getPojo();
        if (command.getUrlType() != null && command.getUrlType().equals(WebConstant.URL_LIST)) {
            if (command.getCrudaction() != null && command.getCrudaction().equals(WebConstant.REDIRECT_DELETE)) {
                List<Integer> ids = new ArrayList<Integer>();
                for (String item: command.getCheckList()) {
                    ids.add(Integer.parseInt(item));
                }
                Integer result = SingletonServiceUtil.getOrderItemsServiceInstance().delete(ids);
                if (result != ids.size()) {
                    command.setCrudaction(WebConstant.REDIRECT_ERROR);
                }
            }
            executeSearchOrder(request, command);
            if (command.getCrudaction() != null) {
                Map<String, String> mapMessage = buidMapRedirectMessage();
                WebCommonUtil.addRedirectMessage(request, command.getCrudaction(), mapMessage);
            }
            request.setAttribute(WebConstant.LIST_ITEMS, command);
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/order/list.jsp");
            rd.forward(request, response);
        }
        // } else if (command.getUrlType() != null && command.getUrlType().equals(WebConstant.URL_EDIT)) {
        //     if (pojo != null && pojo.getOrderItemId() != null) {
        //         command.setPojo(SingletonServiceUtil.get().findById(pojo.getOrderItemId()));
        //     }
        //     command.setDiscounts(SingletonServiceUtil.getDiscountServiceInstance().findAll());
        //     command.setManuFacters(SingletonServiceUtil.getManuFacterServiceInstance().findAll());
        //     request.setAttribute(WebConstant.FORM_ITEM, command);
        //     RequestDispatcher rd = request.getRequestDispatcher("/views/admin/product/edit.jsp");
        //     rd.forward(request, response);
        // }
    }

    private void executeSearchOrder(HttpServletRequest request, OrderCommand command) {
        Map<String, Object> properties = buildMapProperties(command);
        RequestUtil.initSearchBean(request, command);
        Object[] objects = SingletonServiceUtil.getOrderItemsServiceInstance().findByProperty(properties, command.getSortExpression(), command.getSortDirection(),command.getFirstItem(),command.getMaxPageItems());
        command.setListResult((List<OrderItemDTO>) objects[1]);
        command.setTotalItems(Integer.parseInt(objects[0].toString()));
    }

    private Map<String,Object> buildMapProperties(OrderCommand command) {
        Map<String, Object> properties = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(command.getPojo().getCreatedDate().toString())) {
            properties.put("createdDate", command.getPojo().getCreatedDate().toString());
        }
        return properties;
    }

    private Map<String, String> buidMapRedirectMessage() {
        Map<String, String> mapMessage = new HashMap<String, String>();
        mapMessage.put(WebConstant.REDIRECT_INSERT, "Add Order Success");
        mapMessage.put(WebConstant.REDIRECT_UPDATE, "Update Order Success");
        mapMessage.put(WebConstant.REDIRECT_DELETE, "Delete Order Success");
        mapMessage.put(WebConstant.REDIRECT_IMPORT, "Import Order Success");
        mapMessage.put(WebConstant.REDIRECT_ERROR, "An error occurred");
        return mapMessage;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
    }

}

