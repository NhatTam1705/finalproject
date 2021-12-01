/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.web.utils;

import com.project.core.service.impl.RolesServiceImpl;
import com.project.core.service.impl.UsersServiceImpl;

/**
 *
 * @author 19110
 */
public class SingletonServiceUtil {
    public static UsersServiceImpl usersServiceImpl = null;
    public static RolesServiceImpl rolesServiceImpl = null;

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
}
