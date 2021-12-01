/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.project.core.dao.UsersDao;
import com.project.core.daoimpl.UsersDaoImpl;
import com.project.core.dto.CheckLogin;
import com.project.core.dto.UsersDTO;
import com.project.core.persistence.entity.UsersEntity;
import com.project.core.service.UsersService;
import com.project.core.service.util.SingletonDaoUtil;
import com.project.core.utils.UsersBeanUtil;

/**
 *
 * @author 19110
 */
public class UsersServiceImpl implements UsersService {
    public Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        Object[] objects = SingletonDaoUtil.getUsersDaoInstance().findByProperty(property, sortExpression, sortDirection, offset, limit);
        List<UsersDTO> usersDTOs = new ArrayList<UsersDTO>();
        for (UsersEntity item : (List<UsersEntity>)objects[1]) {
            UsersDTO usersDTO = UsersBeanUtil.entityToDto(item);
            usersDTOs.add(usersDTO);
        }
        objects[1] = usersDTOs;
        return objects;
    }

    public UsersDTO findById(Integer userId) {
        UsersEntity entity = SingletonDaoUtil.getUsersDaoInstance().findById(userId);
        UsersDTO dto = UsersBeanUtil.entityToDto(entity);
        return dto;
    }

    public void saveUser(UsersDTO usersDTO) {
        Timestamp createdDate = new Timestamp(System.currentTimeMillis());
        usersDTO.setCreateDate(createdDate);
        UsersEntity entity = UsersBeanUtil.dtoToEntity(usersDTO);
        SingletonDaoUtil.getUsersDaoInstance().save(entity);
    }

    public UsersDTO updateUser(UsersDTO usersDTO) {
        Timestamp createdDate = new Timestamp(System.currentTimeMillis());
        usersDTO.setCreateDate(createdDate);
        UsersEntity entity = UsersBeanUtil.dtoToEntity(usersDTO);
        entity = SingletonDaoUtil.getUsersDaoInstance().update(entity);
        usersDTO = UsersBeanUtil.entityToDto(entity);
        return usersDTO;
    }

    public CheckLogin checkLogin(String email, String telephone, String password) {
        CheckLogin checkLogin = new CheckLogin();
        if (password != null) {
            if (email != null) {
                Object[] objects = SingletonDaoUtil.getUsersDaoInstance().checkLogin(email, null, password);
                checkLogin.setUserExist((Boolean) objects[0]);
                if (checkLogin.isUserExist()) {
                    checkLogin.setRoleName(objects[1].toString());
                }
            } else if (telephone != null) {
                Object[] objects = SingletonDaoUtil.getUsersDaoInstance().checkLogin(null, telephone, password);
                checkLogin.setUserExist((Boolean) objects[0]);
                if (checkLogin.isUserExist()) {
                    checkLogin.setRoleName(objects[1].toString());
                }
            }           
        }
        return checkLogin;
    }
}
