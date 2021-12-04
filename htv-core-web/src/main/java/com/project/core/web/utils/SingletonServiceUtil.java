/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.web.utils;

import com.project.core.service.impl.DiscountServiceImpl;
import com.project.core.service.impl.ManuFacterServiceImpl;
import com.project.core.service.impl.OrderDetailsServiceImpl;
import com.project.core.service.impl.OrderItemsServiceImpl;
import com.project.core.service.impl.ProductServiceImpl;
import com.project.core.service.impl.RolesServiceImpl;
import com.project.core.service.impl.UsersServiceImpl;

/**
 *
 * @author 19110
 */
public class SingletonServiceUtil {
    public static UsersServiceImpl usersServiceImpl = null;
    public static RolesServiceImpl rolesServiceImpl = null;
    public static ProductServiceImpl productServiceImpl = null;
    public static ManuFacterServiceImpl manuFacterServiceImpl = null;
    public static DiscountServiceImpl discountServiceImpl = null;
    public static OrderItemsServiceImpl orderItemsServiceImpl = null;
    public static OrderDetailsServiceImpl orderDetailsServiceImpl = null;

    public static UsersServiceImpl getUsersServiceInstance() {
        if (usersServiceImpl == null) {
            usersServiceImpl = new UsersServiceImpl();
        }
        return usersServiceImpl;
    }

    public static RolesServiceImpl getRolesServiceInstance() {
        if (rolesServiceImpl == null) {
            rolesServiceImpl = new RolesServiceImpl();
        }
        return rolesServiceImpl;
    }

    public static ProductServiceImpl getProductServiceInstance() {
        if (productServiceImpl == null) {
            productServiceImpl = new ProductServiceImpl();
        }
        return productServiceImpl;
    }

    public static ManuFacterServiceImpl getManuFacterServiceInstance() {
        if (manuFacterServiceImpl == null) {
            manuFacterServiceImpl = new ManuFacterServiceImpl();
        }
        return manuFacterServiceImpl;
    }

    public static DiscountServiceImpl getDiscountServiceInstance() {
        if (discountServiceImpl == null) {
            discountServiceImpl = new DiscountServiceImpl();
        }
        return discountServiceImpl;
    }

    public static OrderItemsServiceImpl getOrderItemsServiceInstance() {
        if (orderItemsServiceImpl == null) {
            orderItemsServiceImpl = new OrderItemsServiceImpl();
        }
        return orderItemsServiceImpl;
    }

    public static OrderDetailsServiceImpl getOrderDetailsServiceInstance() {
        if (orderDetailsServiceImpl == null) {
            orderDetailsServiceImpl = new OrderDetailsServiceImpl();
        }
        return orderDetailsServiceImpl;
    }
}
