/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.service.util;

import com.project.core.daoimpl.CartItemDaoImpl;
import com.project.core.daoimpl.DiscountDaoImpl;
import com.project.core.daoimpl.ManuFacterDaoImpl;
import com.project.core.daoimpl.OrderDetailsDaoImpl;
import com.project.core.daoimpl.OrderItemsDaoImpl;
import com.project.core.daoimpl.PaymentDetailsDaoImpl;
import com.project.core.daoimpl.ProductDaoImpl;
import com.project.core.daoimpl.ProductTypeDaoImpl;
import com.project.core.daoimpl.RolesDaoImpl;
import com.project.core.daoimpl.ShoppingSessionDaoImpl;
import com.project.core.daoimpl.UsersDaoImpl;

/**
 *
 * @author 19110
 */
public class SingletonDaoUtil {
    public static UsersDaoImpl usersDaoImpl = null;
    public static CartItemDaoImpl cartItemDTOImpl = null;
    public static DiscountDaoImpl discountDTOImpl = null;
    public static ManuFacterDaoImpl manuFacterDaoImpl = null;
    public static OrderDetailsDaoImpl orderDetailsDTOImpl = null;
    public static OrderItemsDaoImpl orserItemDaoImpl = null;
    public static PaymentDetailsDaoImpl paymentDetailsDTOImpl = null;
    public static ProductDaoImpl productDTOImpl = null;
    public static ProductTypeDaoImpl productTypeDTOImpl = null;
    public static RolesDaoImpl rolesDTOImpl = null;
    public static ShoppingSessionDaoImpl shoppingSessionDTOImpl = null;

    public static UsersDaoImpl getUsersDaoInstance() {
        if (usersDaoImpl == null) {
            usersDaoImpl = new UsersDaoImpl();
        }
        return usersDaoImpl;
    }

    public static CartItemDaoImpl getCartItemDaoInstance() {
        if (cartItemDTOImpl == null) {
            cartItemDTOImpl = new CartItemDaoImpl();
        }
        return cartItemDTOImpl;
    }

    public static DiscountDaoImpl getDiscountDaoInstance() {
        if (discountDTOImpl == null) {
            discountDTOImpl = new DiscountDaoImpl();
        }
        return discountDTOImpl;
    }

    public static ManuFacterDaoImpl getManuFacterDaoInstance() {
        if (manuFacterDaoImpl == null) {
            manuFacterDaoImpl = new ManuFacterDaoImpl();
        }
        return manuFacterDaoImpl;
    }

    public static OrderDetailsDaoImpl getOrderDetailsDaoInstance() {
        if (orderDetailsDTOImpl == null) {
            orderDetailsDTOImpl = new OrderDetailsDaoImpl();
        }
        return orderDetailsDTOImpl;
    }

    public static OrderItemsDaoImpl getOrderItemsDaoInstance() {
        if (orserItemDaoImpl == null) {
            orserItemDaoImpl = new OrderItemsDaoImpl();
        }
        return orserItemDaoImpl;
    }

    public static PaymentDetailsDaoImpl getPaymentDetailsDaoInstance() {
        if (paymentDetailsDTOImpl == null) {
            paymentDetailsDTOImpl = new PaymentDetailsDaoImpl();
        }
        return paymentDetailsDTOImpl;
    }

    public static ProductDaoImpl getProductDaoInstance() {
        if (productDTOImpl == null) {
            productDTOImpl = new ProductDaoImpl();
        }
        return productDTOImpl;
    }

    public static ProductTypeDaoImpl getProductTypeDaoInstance() {
        if (productTypeDTOImpl == null) {
            productTypeDTOImpl = new ProductTypeDaoImpl();
        }
        return productTypeDTOImpl;
    }

    public static RolesDaoImpl getRolesDaoInstance() {
        if (rolesDTOImpl == null) {
            rolesDTOImpl = new RolesDaoImpl();
        }
        return rolesDTOImpl;
    }

    public static ShoppingSessionDaoImpl getShoppingSessionDaoInstance() {
        if (shoppingSessionDTOImpl == null) {
            shoppingSessionDTOImpl = new ShoppingSessionDaoImpl();
        }
        return shoppingSessionDTOImpl;
    }
    
}
