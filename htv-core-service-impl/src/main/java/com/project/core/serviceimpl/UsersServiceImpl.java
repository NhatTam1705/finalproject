/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.project.core.dao.UsersDao;
import com.project.core.daoimpl.UsersDaoImpl;
import com.project.core.dto.UsersDTO;
import com.project.core.persistence.entity.UsersEntity;
import com.project.core.service.UsersService;
import com.project.core.utils.UsersBeanUtil;

/**
 *
 * @author 19110
 */
public class UsersServiceImpl implements UsersService {
    private UsersDao usersDao = new UsersDaoImpl();
    public UsersDTO isUserExist(UsersDTO dto) {
        UsersEntity entity = usersDao.isUserExist(dto.getEmail(), dto.getTelephone(), dto.getPassword());
        return UsersBeanUtil.entityToDto(entity);
    }

    public UsersDTO findRoleByUser(UsersDTO dto) {
        UsersEntity entity = usersDao.findRoleByUser(dto.getEmail(), dto.getTelephone(), dto.getPassword());
        return UsersBeanUtil.entityToDto(entity);
    }

    public Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        Object[] objects = usersDao.findByProperty(property, sortExpression, sortDirection, offset, limit);
        List<UsersDTO> usersDTOs = new ArrayList<UsersDTO>();
        for (UsersEntity item : (List<UsersEntity>)objects[1]) {
            UsersDTO usersDTO = UsersBeanUtil.entityToDto(item);
            usersDTOs.add(usersDTO);
        }
        objects[1] = usersDTOs;
        return objects;
    }

    public UsersDTO findById(Integer userId) {
        UsersEntity entity = usersDao.findById(userId);
        UsersDTO dto = UsersBeanUtil.entityToDto(entity);
        return dto;
    }
}
