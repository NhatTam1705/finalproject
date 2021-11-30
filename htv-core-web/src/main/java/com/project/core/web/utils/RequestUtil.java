/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.web.utils;

import javax.servlet.http.HttpServletRequest;

import com.project.core.web.command.AbstractCommand;

import org.apache.commons.lang.StringUtils;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;



/**
 *
 * @author 19110
 */
public class RequestUtil {
    public static void initSearchBean(HttpServletRequest request, AbstractCommand bean) {
        if (bean != null) {
            String sortExpression = request.getParameter(new ParamEncoder(bean.getTableId()).encodeParameterName(TableTagParameters.PARAMETER_SORT));
            String sortDirection = request.getParameter(new ParamEncoder(bean.getTableId()).encodeParameterName(TableTagParameters.PARAMETER_ORDER));
            String pageStr = request.getParameter(new ParamEncoder(bean.getTableId()).encodeParameterName(TableTagParameters.PARAMETER_PAGE));

            Integer page = 1;
            if (StringUtils.isNotBlank(pageStr)) {
                try {
                    page = Integer.valueOf(pageStr);
                } catch (Exception e) {
                    //ignore
                }
            }
            bean.setPage(page);
            bean.setSortDirection(sortDirection);
            bean.setSortExpression(sortExpression);
            bean.setFirstItem((bean.getPage() - 1) * bean.getMaxPageItems());
        }
    }
}
