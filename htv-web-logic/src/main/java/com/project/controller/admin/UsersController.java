/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.controller.admin;

import com.project.command.UsersCommand;
import com.project.core.dto.RolesDTO;
import com.project.core.dto.UsersDTO;
import com.project.core.service.RolesService;
import com.project.core.service.UsersService;
import com.project.core.service.impl.RolesServiceImpl;
import com.project.core.service.impl.UsersServiceImpl;
import com.project.core.web.common.WebConstant;
import com.project.core.web.utils.FormUtil;
import com.project.core.web.utils.RequestUtil;
import com.project.core.web.utils.SingletonServiceUtil;
import com.project.core.web.utils.WebCommonUtil;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 19110
 */
@WebServlet(urlPatterns = {"/admin-users-list.html", "/ajax-admin-users-edit.html"})
public class UsersController extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsersCommand command = FormUtil.populate(UsersCommand.class, request);
        UsersDTO pojo = command.getPojo();
        if (command.getUrlType() != null && command.getUrlType().equals(WebConstant.URL_LIST)) {
            Map<String, Object> mapProperty = new HashMap<String, Object>();
            RequestUtil.initSearchBean(request, command);
            Object[] objects = SingletonServiceUtil.getUsersServiceInstance().findByProperty(mapProperty, command.getSortExpression(),
                    command.getSortDirection(), command.getFirstItem(), command.getMaxPageItems());
            command.setListResult((List<UsersDTO>) objects[1]);
            command.setTotalItems(Integer.parseInt(objects[0].toString()));
            request.setAttribute(WebConstant.LIST_ITEMS, command);
            if (command.getCrudaction() != null) {
                Map<String, String> mapMessage = buidMapRedirectMessage();
                WebCommonUtil.addRedirectMessage(request, command.getCrudaction(), mapMessage);
            }
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/users/list.jsp");
            rd.forward(request, response);
        } else if (command.getUrlType() != null && command.getUrlType().equals(WebConstant.URL_EDIT)) {
            if (pojo != null && pojo.getUserId() != null) {
                command.setPojo(SingletonServiceUtil.getUsersServiceInstance().findById(pojo.getUserId()));
            }
            command.setRoles(SingletonServiceUtil.getRolesServiceInstance().findAll());
            request.setAttribute(WebConstant.FORM_ITEM, command);
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/users/edit.jsp");
            rd.forward(request, response);
        }
    }

    private Map<String, String> buidMapRedirectMessage() {
        Map<String, String> mapMessage = new HashMap<String, String>();
        mapMessage.put(WebConstant.REDIRECT_INSERT, "Add User Success");
        mapMessage.put(WebConstant.REDIRECT_UPDATE, "Update User Success");
        mapMessage.put(WebConstant.REDIRECT_DELETE, "Delete User Success");
        mapMessage.put(WebConstant.REDIRECT_ERROR, "An error occurred");
        return mapMessage;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            UsersCommand command = FormUtil.populate(UsersCommand.class, request);
            UsersDTO pojo = command.getPojo();
            if (command.getUrlType() != null && command.getUrlType().equals(WebConstant.URL_EDIT)) {
                if (command.getCrudaction() != null && command.getCrudaction().equals(WebConstant.INSERT_UPDATE)) {
                    RolesDTO rolesDTO = new RolesDTO();
                    rolesDTO.setRoleId(command.getRoleId());
                    pojo.setRolesDTO(rolesDTO);
                    if (pojo != null && pojo.getUserId() != null) {
                        SingletonServiceUtil.getUsersServiceInstance().updateUser(pojo);
                        request.setAttribute(WebConstant.MESSAGE_RESPONSE, WebConstant.REDIRECT_UPDATE);
                    } else {
                        SingletonServiceUtil.getUsersServiceInstance().saveUser(pojo);
                        request.setAttribute(WebConstant.MESSAGE_RESPONSE, WebConstant.REDIRECT_INSERT);
                    }
                }
                RequestDispatcher rd = request.getRequestDispatcher("/views/admin/users/edit.jsp");
                rd.forward(request, response);
            }
            // if (objects != null) {
            //     String urlType = null;
            //     Map<String, String> mapValue = (Map<String, String>) objects[3];
            //     for (Map.Entry<String, String> item: mapValue.entrySet()) {
            //         if (item.getKey().equals("urlType")) {
            //             urlType = item.getValue();
            //         }
            //     }
            //     if (urlType != null && urlType.equals(READ_EXCEL)) {
            //         String fileLocation = objects[1].toString();
            //         String fileName = objects[2].toString();
            //         List<UserImportDTO> excelValues = returnValueFromExcel(fileName, fileLocation);
            //         validateData(excelValues);
            //         SessionUtil.getInstance().putValue(request, LIST_USER_IMPORT, excelValues);
            //         response.sendRedirect("/admin-user-import-validate.html?urlType=validate_import");
            //     }
            // }
            // if (command.getUrlType() != null && command.getUrlType().equals(IMPORT_DATA)) {
            //     List<UserImportDTO> userImportDTOS = (List<UserImportDTO>) SessionUtil.getInstance().getValue(request, LIST_USER_IMPORT);
            //     SingletonServiceUtil.getUserServiceInstance().saveUserImport(userImportDTOS);
            //     SessionUtil.getInstance().remove(request, LIST_USER_IMPORT);
            //     response.sendRedirect("/admin-user-list.html?urlType=url_list");
            // }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            request.setAttribute(WebConstant.MESSAGE_RESPONSE, WebConstant.REDIRECT_ERROR);
        }
    }
}

