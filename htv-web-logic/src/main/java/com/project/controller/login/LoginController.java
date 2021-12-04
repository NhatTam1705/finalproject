/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.controller.login;

import com.project.command.UsersCommand;
import com.project.core.common.utils.SessionUtil;
import com.project.core.dto.CheckLogin;
import com.project.core.dto.UsersDTO;
import com.project.core.persistence.entity.UsersEntity;
import com.project.core.service.UsersService;
import com.project.core.service.impl.UsersServiceImpl;
import com.project.core.service.util.SingletonDaoUtil;
import com.project.core.web.common.WebConstant;
import com.project.core.web.utils.FormUtil;
import com.project.core.web.utils.SingletonServiceUtil;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 *
 * @author 19110
 */
@WebServlet(urlPatterns = {"/logincommon-home.html","/logout.html"})
public class LoginController extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals(WebConstant.LOGIN)) {
            RequestDispatcher rd = request.getRequestDispatcher("/views/login/home.jsp");
            rd.forward(request, response);
        } else if(action.equals(WebConstant.LOGOUT)) {
            SessionUtil.getInstance().remove(request, WebConstant.LOGIN_NAME);
            response.sendRedirect("/htv-web/home.html");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsersCommand command = FormUtil.populate(UsersCommand.class, request);
        UsersDTO pojo = command.getPojo();
        if (pojo != null) {
            CheckLogin login = SingletonServiceUtil.getUsersServiceInstance().checkLogin(pojo.getEmail(), pojo.getTelephone(), pojo.getPassword());
            if (login.isUserExist()) {
                UsersEntity user = new UsersEntity();
                if(pojo.getEmail() != null)
                {
                    user = SingletonDaoUtil.getUsersDaoInstance().findEqualUnique("email", pojo.getEmail());
                }
                if(pojo.getTelephone() != null)
                {
                    user = SingletonDaoUtil.getUsersDaoInstance().findEqualUnique("telephone", pojo.getTelephone());
                }
                SessionUtil.getInstance().putValue(request, WebConstant.LOGIN_NAME, user.getLastName());
                if (login.getRoleName().equals(WebConstant.ROLE_ADMIN)) {
                    response.sendRedirect("/htv-web/admin-home.html"); 
                } else if (login.getRoleName().equals(WebConstant.ROLE_USER)) {
                    response.sendRedirect("/htv-web/home.html");
                }
            } else {
                request.setAttribute(WebConstant.ALERT, WebConstant.TYPE_ERROR);
                request.setAttribute(WebConstant.MESSAGE_RESPONSE, "Incorrect account or password.");
                RequestDispatcher rd = request.getRequestDispatcher("/views/login/home.jsp");
                rd.forward(request, response);
            }
        }
    }
}
