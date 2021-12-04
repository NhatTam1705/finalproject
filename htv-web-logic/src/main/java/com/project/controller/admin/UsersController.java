/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.controller.admin;

import com.project.command.UsersCommand;
import com.project.core.common.utils.ExcelPoiUtil;
import com.project.core.common.utils.SessionUtil;
import com.project.core.common.utils.UploadUtil;
import com.project.core.dto.RolesDTO;
import com.project.core.dto.UserImportDTO;
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

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
@WebServlet(urlPatterns = {"/admin-user-list.html", "/ajax-admin-user-edit.html", "/admin-user-import.html",
                                "/admin-user-import-validate.html"})
public class UsersController extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
    private final String SHOW_IMPORT_USER = "show_import_user";
    private final String READ_EXCEL = "read_excel";
    private final String VALIDATE_IMPORT = "validate_import";
    private final String LIST_USER_IMPORT = "list_user_import";
    private final String IMPORT_DATA = "import_data";
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsersCommand command = FormUtil.populate(UsersCommand.class, request);
        UsersDTO pojo = command.getPojo();
        if (command.getUrlType() != null && command.getUrlType().equals(WebConstant.URL_LIST)) {
            if (command.getCrudaction() != null && command.getCrudaction().equals(WebConstant.REDIRECT_DELETE)) {
                List<Integer> ids = new ArrayList<Integer>();
                for (String item: command.getCheckList()) {
                    ids.add(Integer.parseInt(item));
                }
                Integer result = SingletonServiceUtil.getUsersServiceInstance().delete(ids);
                if (result != ids.size()) {
                    command.setCrudaction(WebConstant.REDIRECT_ERROR);
                }
            }
            executeSearchUser(request, command);
            request.setAttribute(WebConstant.LIST_ITEMS, command);
            if (command.getCrudaction() != null) {
                Map<String, String> mapMessage = buidMapRedirectMessage();
                WebCommonUtil.addRedirectMessage(request, command.getCrudaction(), mapMessage);
            }
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/list.jsp");
            rd.forward(request, response);
        } else if (command.getUrlType() != null && command.getUrlType().equals(WebConstant.URL_EDIT)) {
            if (pojo != null && pojo.getUserId() != null) {
                command.setPojo(SingletonServiceUtil.getUsersServiceInstance().findById(pojo.getUserId()));
            }
            command.setRoles(SingletonServiceUtil.getRolesServiceInstance().findAll());
            request.setAttribute(WebConstant.FORM_ITEM, command);
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/edit.jsp");
            rd.forward(request, response);
        } else if (command.getUrlType() != null && command.getUrlType().equals(SHOW_IMPORT_USER)) {
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/importuser.jsp");
            rd.forward(request, response);
        } else if (command.getUrlType() != null && command.getUrlType().equals(VALIDATE_IMPORT)) {
            List<UserImportDTO> userImportDTOS = (List<UserImportDTO>) SessionUtil.getInstance().getValue(request, LIST_USER_IMPORT);
            command.setUserImportDTOS(returnListUserImport(command, userImportDTOS, request));
            request.setAttribute(WebConstant.LIST_ITEMS, command);
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/importuser.jsp");
            rd.forward(request, response);
        }
    }

    private void executeSearchUser(HttpServletRequest request, UsersCommand command) {
        Map<String, Object> properties = buildMapProperties(command);
        RequestUtil.initSearchBean(request, command);
        Object[] objects = SingletonServiceUtil.getUsersServiceInstance().findByProperty(properties, command.getSortExpression(), command.getSortDirection(),command.getFirstItem(),command.getMaxPageItems());
        command.setListResult((List<UsersDTO>) objects[1]);
        command.setTotalItems(Integer.parseInt(objects[0].toString()));
    }

    private Map<String,Object> buildMapProperties(UsersCommand command) {
        Map<String, Object> properties = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(command.getPojo().getLastName())) {
            properties.put("lastName", command.getPojo().getLastName());
        }
        return properties;
    }

    private List<UserImportDTO> returnListUserImport(UsersCommand command, List<UserImportDTO> userImportDTOS, HttpServletRequest request) {
        command.setMaxPageItems(3);
    RequestUtil.initSearchBean(request, command);
    command.setTotalItems(userImportDTOS.size());
    int fromIndex = command.getFirstItem();
    if (fromIndex > command.getTotalItems()) {
        fromIndex = 0;
        command.setFirstItem(0);
    }
    int toIndex = command.getFirstItem() + command.getMaxPageItems();
    if (userImportDTOS.size() > 0) {
        if (toIndex > userImportDTOS.size()) {
            toIndex = userImportDTOS.size();
        }
    }
    return userImportDTOS.subList(fromIndex, toIndex);
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
        UploadUtil uploadUtil = new UploadUtil();
        Set<String> value = new HashSet<String>();
        value.add("urlType");
        Object[] objects = uploadUtil.writeOrUpdateFile(request, value, "excel");
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
                RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/edit.jsp");
                rd.forward(request, response);
            }
            if (objects != null) {
                String urlType = null;
                Map<String, String> mapValue = (Map<String, String>) objects[3];
                for (Map.Entry<String, String> item: mapValue.entrySet()) {
                    if (item.getKey().equals("urlType")) {
                        urlType = item.getValue();
                    }
                }
                if (urlType != null && urlType.equals(READ_EXCEL)) {
                    String fileLocation = objects[1].toString();
                    String fileName = objects[2].toString();
                    List<UserImportDTO> excelValues = returnValueFromExcel(fileName, fileLocation);
                    validateData(excelValues);
                    SessionUtil.getInstance().putValue(request, LIST_USER_IMPORT, excelValues);
                    response.sendRedirect("/htv-web/admin-user-import-validate.html?urlType=validate_import");
                }
            }
            if (command.getUrlType() != null && command.getUrlType().equals(IMPORT_DATA)) {
                List<UserImportDTO> userImportDTOS = (List<UserImportDTO>) SessionUtil.getInstance().getValue(request, LIST_USER_IMPORT);
                SingletonServiceUtil.getUsersServiceInstance().saveUserImport(userImportDTOS);
                SessionUtil.getInstance().remove(request, LIST_USER_IMPORT);
                // request.setAttribute(WebConstant.ALERT, WebConstant.TYPE_SUCCESS);
                // request.setAttribute(WebConstant.MESSAGE_RESPONSE, "Import User Success");
                response.sendRedirect("/htv-web/admin-user-list.html?urlType=url_list");               
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            request.setAttribute(WebConstant.MESSAGE_RESPONSE, WebConstant.REDIRECT_ERROR);
        }
    }

    private List<UserImportDTO> returnValueFromExcel(String fileName, String fileLocation) throws IOException{
        Workbook workbook = ExcelPoiUtil.getWorkBook(fileName, fileLocation);
        Sheet sheet = workbook.getSheetAt(0);
        List<UserImportDTO> excelValues = new ArrayList<UserImportDTO>();
                    for (int i=1; i <= sheet.getLastRowNum(); i++) {
                        Row row = sheet.getRow(i);
                        UserImportDTO userImportDTO = readDataFromExcel(row);
                        excelValues.add(userImportDTO);
                    }
        return excelValues;
    }

    private UserImportDTO readDataFromExcel(Row row) {
        UserImportDTO userImportDTO = new UserImportDTO();
        userImportDTO.setPassword(ExcelPoiUtil.getCellValue(row.getCell(0)));
        userImportDTO.setFirstName(ExcelPoiUtil.getCellValue(row.getCell(1)));
        userImportDTO.setLastName(ExcelPoiUtil.getCellValue(row.getCell(2)));
        userImportDTO.setAddress(ExcelPoiUtil.getCellValue(row.getCell(3)));
        userImportDTO.setPhone(ExcelPoiUtil.getCellValue(row.getCell(4)));
        userImportDTO.setEmail(ExcelPoiUtil.getCellValue(row.getCell(5)));
        userImportDTO.setRoleName(ExcelPoiUtil.getCellValue(row.getCell(6)));
        return userImportDTO;
    }

    private void validateData(List<UserImportDTO> excelValues) {
        Set<String> stringSet = new HashSet<String>();
        for (UserImportDTO item: excelValues) {
            validateRequireField(item);
            validateDuplicate(item, stringSet);
        }
        SingletonServiceUtil.getUsersServiceInstance().validateImportUser(excelValues);
    }

    private void validateDuplicate(UserImportDTO item, Set<String> stringSet) {
        String message = item.getError();
        boolean check = false;
        if (!stringSet.contains(item.getPhone())) {
            stringSet.add(item.getPhone());
            check = true;
        } else if (!stringSet.contains(item.getEmail())) {
            stringSet.add(item.getEmail());
        } else {
            if (item.isValid()) {
                if (check) {
                    message += "<br/>";
                    message = "Phone is duplicate";
                } else {
                    message += "<br/>";
                    message = "Email is duplicate";
                }
            }
        }
        if (StringUtils.isNotBlank(message)) {
            item.setValid(false);
            item.setError(message.substring(5));
        }
    }

    private void validateRequireField(UserImportDTO item) {
        String message = "";
        if (StringUtils.isBlank(item.getPassword())) {
            message += "<br/>";
            message += "Password is not blank.";
        }
        if (StringUtils.isBlank(item.getPhone())) {
            message += "<br/>";
            message += "Phone is not blank.";
        }
        if (StringUtils.isBlank(item.getEmail())) {
            message += "<br/>";
            message += "Email is not blank.";
        }
        if (StringUtils.isBlank(item.getRoleName())) {
            message += "<br/>";
            message += "Role is not blank.";
        }
        if (StringUtils.isNotBlank(message)) {
            item.setValid(false);
        }
        item.setError(message);
    }
}

