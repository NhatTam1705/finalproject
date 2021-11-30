/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.controller.admin;

import com.project.command.UsersCommand;
import com.project.core.dto.UsersDTO;
import com.project.core.service.RolesService;
import com.project.core.service.UsersService;
import com.project.core.serviceimpl.RolesServiceImpl;
import com.project.core.serviceimpl.UsersServiceImpl;
import com.project.core.web.common.WebConstant;
import com.project.core.web.utils.FormUtil;
import com.project.core.web.utils.RequestUtil;

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
    private UsersService usersService = new UsersServiceImpl();
    private RolesService rolesService = new RolesServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsersCommand command = FormUtil.populate(UsersCommand.class, request);
        UsersDTO pojo = command.getPojo();
        if(command.getUrlType().equals(WebConstant.URL_LIST)) {
            Map<String, Object> mapProperty = new HashMap<String, Object>();
            Object[] objects = usersService.findByProperty(mapProperty, command.getSortExpression(), 
                command.getSortDirection(), command.getFirstItem(), command.getMaxPageItems());
            command.setMaxPageItems(2);
            command.setListResult((List<UsersDTO>) objects[1]);
            command.setTotalItems(Integer.parseInt(objects[0].toString()));
            request.setAttribute(WebConstant.LIST_ITEMS, command);
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/users/list.jsp");
            rd.forward(request, response);
        } else if (command.getUrlType().equals(WebConstant.URL_EDIT)) {
            if (pojo != null && pojo.getUserId() != null) {
                command.setPojo(usersService.findById(pojo.getUserId()));
            }
            command.setRoles(rolesService.findAll());
            request.setAttribute(WebConstant.FORM_ITEM, command);
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/users/edit.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
