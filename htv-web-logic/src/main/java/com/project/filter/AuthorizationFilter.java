/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.filter;


import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

import com.project.core.common.utils.SessionUtil;
import com.project.core.dto.UsersDTO;
import com.project.core.web.common.WebConstant;

/**
 *
 * @author asus
 */
public class AuthorizationFilter implements Filter {

    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI();
        if (url.startsWith(request.getContextPath()+"/admin")) {
            UsersDTO user = (UsersDTO) SessionUtil.getInstance().getValue(request, WebConstant.LOGIN_NAME);
            if (user != null) {
                if (user.getRolesDTO().getRoleName().equals(WebConstant.ROLE_ADMIN)) {
                    filterChain.doFilter(servletRequest, servletResponse);
                } else if (user.getRolesDTO().getRoleName().equals(WebConstant.ROLE_USER)) {
//                    response.sendRedirect(request.getContextPath()
//                            + "/dang-nhap?action=login&message=not_permission&alert=warning");
                request.setAttribute(WebConstant.ALERT, WebConstant.TYPE_ERROR);
                request.setAttribute(WebConstant.MESSAGE_RESPONSE, "Not permission.");
                    response.sendRedirect(request.getContextPath()
                            + "/logincommon-home.html?action=login");
                }
            } else {
                request.setAttribute(WebConstant.ALERT, WebConstant.TYPE_ERROR);
                request.setAttribute(WebConstant.MESSAGE_RESPONSE, "Not login.");
                response.sendRedirect(
                        request.getContextPath() + "/logincommon-home.html?action=login");
                        
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
    }

}
