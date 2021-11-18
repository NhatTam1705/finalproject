/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.web.utils;

import java.lang.reflect.InvocationTargetException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author 19110
 */
public class FormUtil {
    public static <T> T populate(Class<T> clazz, HttpServletRequest request) {
        T object = null;
        try {
            object = (T) clazz.newInstance();
            BeanUtils.populate(object, request.getParameterMap());
        } catch (InstantiationException e) {

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return object;
    }
}
