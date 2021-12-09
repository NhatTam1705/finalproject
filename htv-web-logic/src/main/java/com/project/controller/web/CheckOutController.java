/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.project.core.common.utils.SessionUtil;
import com.project.core.dto.OrderDetailsDTO;
import com.project.core.dto.OrderItemDTO;
import com.project.core.dto.UsersDTO;
import com.project.core.web.common.WebConstant;
import com.project.core.web.utils.SingletonServiceUtil;

/**
 *
 * @author 19110
 */
@WebServlet(urlPatterns={"/check-out"})
public class CheckOutController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsersDTO user = (UsersDTO) SessionUtil.getInstance().getValue(request, WebConstant.LOGIN_NAME);
        if (user == null) {
            response.sendRedirect(request.getContextPath()+"/logincommon-home.html?action=login");                  
        } else {
                OrderDetailsDTO order = (OrderDetailsDTO) SessionUtil.getInstance().getValue(request, "order");
                order.setUsers(user);
                Integer orderDetailId = SingletonServiceUtil.getOrderDetailsServiceInstance().save(order);
                order.setOrderId(orderDetailId);
                List<OrderItemDTO> listItems = order.getOrderItemsDTOList();
                for (OrderItemDTO item : listItems) {
                    item.setOrderDetails(order);
                    SingletonServiceUtil.getOrderItemsServiceInstance().saveOrderItem(item);
                }
                // try {
                //     JavaMailUtil.sendMail(user.getEmail(), MailTemplateUtil.templateMailCongratulation(), "Conratulation!");
                // } catch (MessagingException ex) {
                //     Logger.getLogger(CheckoutController.class.getName()).log(Level.SEVERE, null, ex);
                // }
                SessionUtil.getInstance().remove(request, "order");
                // request.setAttribute(WebConstant.ALERT, WebConstant.TYPE_SUCCESS);
                // request.setAttribute(WebConstant.MESSAGE_RESPONSE, "Check Out successfully an email will send to your mail!");
                response.sendRedirect(request.getContextPath()+"/product-phone-cart.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
