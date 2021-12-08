/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.service;

import java.util.List;
import java.util.Map;

import com.project.core.dto.CheckLogin;
import com.project.core.dto.UserImportDTO;
import com.project.core.dto.UsersDTO;

/**
 *
 * @author 19110
 */
public interface UsersService {
    Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit);
    UsersDTO findById(Integer userId);
    void saveUser(UsersDTO usersDTO);
    UsersDTO updateUser(UsersDTO userDTO);
    CheckLogin checkLogin(String email, String telephone, String password);
    void validateImportUser(List<UserImportDTO> userImportDTOS);
    void saveUserImport(List<UserImportDTO> userImportDTOS);
    Integer delete(List<Integer> ids);
    UsersDTO findUser(String property, String value);
}
