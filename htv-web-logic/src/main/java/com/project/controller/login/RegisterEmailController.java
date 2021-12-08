/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.controller.login;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.command.UsersCommand;
import com.project.core.dto.RolesDTO;
import com.project.core.dto.UsersDTO;
import com.project.core.web.common.WebConstant;
import com.project.core.web.utils.FormUtil;
import com.project.core.web.utils.SingletonServiceUtil;

/**
 *
 * @author 19110
 */
@WebServlet(urlPatterns = {"/register-email.html"})
public class RegisterEmailController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("/views/login/register/RBEmail.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsersCommand command = FormUtil.populate(UsersCommand.class, request);
        UsersDTO pojo = command.getPojo();
        RolesDTO roles = new RolesDTO();
        roles.setRoleId(2);
        pojo.setRolesDTO(roles);
        SingletonServiceUtil.getUsersServiceInstance().saveUser(pojo);
        response.sendRedirect("/htv-web/logincommon-home.html?action=login");
        
    }
}
