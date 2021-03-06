/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.service.util;

import com.project.core.daoimpl.DiscountDaoImpl;
import com.project.core.daoimpl.ManuFacterDaoImpl;
import com.project.core.daoimpl.OrderDetailsDaoImpl;
import com.project.core.daoimpl.OrderItemsDaoImpl;
import com.project.core.daoimpl.ProductDaoImpl;
import com.project.core.daoimpl.RolesDaoImpl;
import com.project.core.daoimpl.UsersDaoImpl;

/**
 *
 * @author 19110
 */
public class SingletonDaoUtil {
    public static UsersDaoImpl usersDaoImpl = null;
    public static DiscountDaoImpl discountDTOImpl = null;
    public static ManuFacterDaoImpl manuFacterDaoImpl = null;
    public static OrderDetailsDaoImpl orderDetailsDTOImpl = null;
    public static OrderItemsDaoImpl orserItemDaoImpl = null;
    public static ProductDaoImpl productDTOImpl = null;
    public static RolesDaoImpl rolesDTOImpl = null;

    public static UsersDaoImpl getUsersDaoInstance() {
        if (usersDaoImpl == null) {
            usersDaoImpl = new UsersDaoImpl();
        }
        return usersDaoImpl;
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

    public static ProductDaoImpl getProductDaoInstance() {
        if (productDTOImpl == null) {
            productDTOImpl = new ProductDaoImpl();
        }
        return productDTOImpl;
    }

    public static RolesDaoImpl getRolesDaoInstance() {
        if (rolesDTOImpl == null) {
            rolesDTOImpl = new RolesDaoImpl();
        }
        return rolesDTOImpl;
    }
}
