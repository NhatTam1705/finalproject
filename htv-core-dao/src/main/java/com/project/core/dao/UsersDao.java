/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.dao;

import com.project.core.data.dao.GenericDao;
import com.project.core.persistence.entity.UsersEntity;

/**
 *
 * @author 19110
 */
public interface UsersDao extends GenericDao<Integer, UsersEntity> {
    UsersEntity isUserExist(String email, String telephone, String password);
    UsersEntity findRoleByUser(String email, String telephone, String password);
}
