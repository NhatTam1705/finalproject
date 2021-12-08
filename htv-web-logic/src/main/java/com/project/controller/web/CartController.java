/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.controller.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.project.core.dto.OrderDetailsDTO;
import com.project.core.dto.OrderItemDTO;
import com.project.core.dto.ProductDTO;
import com.project.core.web.utils.SingletonServiceUtil;

/**
 *
 * @author 19110
 */
@WebServlet(urlPatterns = {"/product-phone-cart.html"})
public class CartController extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                Integer quantity = 1;             
                if (request.getParameter("productId") != null) {
                    String productIdStr = request.getParameter("productId");
                    ProductDTO productDTO = SingletonServiceUtil.getProductServiceInstance().findById(Integer.parseInt(productIdStr));
                    if (productDTO != null) {
                        if (request.getParameter("quantity") != null) {
                            quantity = Integer.parseInt(request.getParameter("quantity"));
                        }
                        HttpSession session = request.getSession();
                        if (session.getAttribute("order") == null) {
                            BigDecimal total = new BigDecimal("0");
                            OrderDetailsDTO order = new OrderDetailsDTO();
                            List<OrderItemDTO> listItems = new ArrayList<OrderItemDTO>();
                            OrderItemDTO item = new OrderItemDTO();
                            item.setQuantity(quantity);
                            item.setProduct(productDTO);
                            listItems.add(item);
                            order.setOrderItemsDTOList(listItems);
                            BigDecimal j = new BigDecimal(quantity);
                            BigDecimal percent = productDTO.getDiscountDTO().getDiscountPercent();
                            BigDecimal b = new BigDecimal(100);
                            // order.setTotal((total.add(productDTO.getPrice())).multiply(j));
                            order.setTotal((total.add(productDTO.getPrice().subtract(productDTO.getPrice().multiply(percent).divide(b)))).multiply(j));
                            session.setAttribute("order", order);
                        } else {
                            OrderDetailsDTO order = (OrderDetailsDTO) session.getAttribute("order");
                            List<OrderItemDTO> listItems = order.getOrderItemsDTOList();
                            boolean check = false;
                            for (OrderItemDTO item : listItems) {
                                if (item.getProduct().getProductId() == productDTO.getProductId()) {
                                    BigDecimal total = new BigDecimal("0");
                                    BigDecimal j = new BigDecimal(quantity);
                                    item.setQuantity(item.getQuantity() + quantity);
                                    BigDecimal percent = productDTO.getDiscountDTO().getDiscountPercent();
                                    BigDecimal b = new BigDecimal(100);
                                    // order.setTotal((total.add(productDTO.getPrice())).multiply(j));
                                    order.setTotal(order.getTotal().add((productDTO.getPrice().subtract(productDTO.getPrice().multiply(percent).divide(b))).multiply(j)));
                                    check = true;
                                }
                            }
                            if (check == false) {
                                OrderItemDTO item1 = new OrderItemDTO();
                                item1.setQuantity(quantity);
                                item1.setProduct(productDTO);
                                listItems.add(item1);
                                BigDecimal j = new BigDecimal(quantity);
                                BigDecimal percent = productDTO.getDiscountDTO().getDiscountPercent();
                                BigDecimal b = new BigDecimal(100);
                                order.setTotal(order.getTotal().add((productDTO.getPrice().subtract(productDTO.getPrice().multiply(percent).divide(b))).multiply(j)));
                            }
                            session.setAttribute("order", order);
                        }
                    }
                    response.sendRedirect("/htv-web/shopping-cart.html");
                } else {
                    response.sendRedirect("/htv-web/shopping-cart.html");
                }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
