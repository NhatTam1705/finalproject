/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.core.dao.UsersDao;
import com.project.core.daoimpl.UsersDaoImpl;
import com.project.core.dto.CheckLogin;
import com.project.core.dto.UserImportDTO;
import com.project.core.dto.UsersDTO;
import com.project.core.persistence.entity.RolesEntity;
import com.project.core.persistence.entity.UsersEntity;
import com.project.core.service.UsersService;
import com.project.core.service.util.SingletonDaoUtil;
import com.project.core.utils.UsersBeanUtil;

import org.apache.commons.lang.StringUtils;

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
        usersDTO.setCreatedDate(createdDate);
        UsersEntity entity = UsersBeanUtil.dtoToEntity(usersDTO);
        SingletonDaoUtil.getUsersDaoInstance().save(entity);
    }

    public UsersDTO updateUser(UsersDTO usersDTO) {
        Timestamp modifiedDate = new Timestamp(System.currentTimeMillis());
        usersDTO.setModifiedDate(modifiedDate);
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

    public void validateImportUser(List<UserImportDTO> userImportDTOS) {
        List<String> phones = new ArrayList<String>();
        List<String> emails = new ArrayList<String>();
        List<String> roles = new ArrayList<String>();

        for(UserImportDTO item: userImportDTOS) {
            if (item.isValid()) {
                phones.add(item.getPhone());
                emails.add(item.getEmail());
                if (!roles.contains(item.getRoleName())) {
                    roles.add(item.getRoleName());
                }
            }
        }

        Map<String, UsersEntity> phoneUserEntityMap = new HashMap<String, UsersEntity>();
        Map<String, UsersEntity> emailUserEntityMap = new HashMap<String, UsersEntity>();
        Map<String, RolesEntity> roleEntityMap = new HashMap<String, RolesEntity>();
        if (phones.size() > 0) {
            List<UsersEntity> phoneUserEntities = SingletonDaoUtil.getUsersDaoInstance().findByUsers(phones, null);
            for (UsersEntity item: phoneUserEntities) {
                phoneUserEntityMap.put(item.getTelephone().toUpperCase(), item);
            }
        }
        if (emails.size() > 0) {
            List<UsersEntity> emailUserEntities = SingletonDaoUtil.getUsersDaoInstance().findByUsers(null, emails);
            for (UsersEntity item: emailUserEntities) {
                emailUserEntityMap.put(item.getEmail().toUpperCase(), item);
            }
        }
        if (roles.size() > 0) {
            List<RolesEntity> roleEntities = SingletonDaoUtil.getRolesDaoInstance().findByRoles(roles);
            for (RolesEntity item: roleEntities) {
                roleEntityMap.put(item.getRoleName().toUpperCase(), item);
            }
        }

        for (UserImportDTO item: userImportDTOS) {
            String message = item.getError();
            if (item.isValid()) {
                UsersEntity phoneUserEntity = phoneUserEntityMap.get(item.getPhone().toUpperCase());
                if (phoneUserEntity != null) {
                    message += "<br/>";
                    message += "Phone already exist.";
                }
                UsersEntity emailUserEntity = emailUserEntityMap.get(item.getEmail().toUpperCase());
                if (emailUserEntity != null) {
                    message += "<br/>";
                    message += "Email already exist.";
                }
                RolesEntity roleEntity = roleEntityMap.get(item.getRoleName().toUpperCase());
                if (roleEntity == null) {
                    message += "<br/>";
                    message += "Role does not exist.";
                }
                if (StringUtils.isNotBlank(message)) {
                    item.setValid(false);
                    item.setError(message.substring(5));
                }
            }
        }
    }

    public void saveUserImport(List<UserImportDTO> userImportDTOS) {
        for (UserImportDTO item: userImportDTOS) {
            if (item.isValid()) {
                UsersEntity userEntity = new UsersEntity();
                userEntity.setPassword(item.getPassword());
                userEntity.setFirstName(item.getFirstName());
                userEntity.setLastName(item.getLastName());
                userEntity.setAddress(item.getAddress());
                userEntity.setTelephone(item.getPhone());
                userEntity.setEmail(item.getEmail());
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                userEntity.setCreatedDate(timestamp);
                RolesEntity roleEntity = SingletonDaoUtil.getRolesDaoInstance().findEqualUnique("roleName", item.getRoleName().toUpperCase());
                userEntity.setRoles(roleEntity);
                SingletonDaoUtil.getUsersDaoInstance().save(userEntity);
            }
        }
    }

    public Integer delete(List<Integer> ids) {
        Integer result = SingletonDaoUtil.getUsersDaoInstance().delete(ids);
        return result;
    }

    public UsersDTO findUser(String property, String value) {
        UsersEntity entity = SingletonDaoUtil.getUsersDaoInstance().findEqualUnique(property, value);
        UsersDTO dto = UsersBeanUtil.entityToDto(entity);
        return dto;
    }
}
