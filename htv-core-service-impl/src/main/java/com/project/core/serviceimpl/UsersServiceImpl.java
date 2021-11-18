/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.serviceimpl;

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
    
    public UsersDTO isUserExist(UsersDTO dto) {
        UsersDao usersDao = new UsersDaoImpl();
        UsersEntity entity = usersDao.isUserExist(dto.getEmail(), dto.getTelephone(), dto.getPassword());
        return UsersBeanUtil.entityToDto(entity);
    }

    public UsersDTO findRoleByUser(UsersDTO dto) {
        UsersDao usersDao = new UsersDaoImpl();
        UsersEntity entity = usersDao.findRoleByUser(dto.getEmail(), dto.getTelephone(), dto.getPassword());
        return UsersBeanUtil.entityToDto(entity);
    }
}
