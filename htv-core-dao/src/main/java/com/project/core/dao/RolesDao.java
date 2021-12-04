/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.dao;

import java.util.List;

import com.project.core.data.dao.GenericDao;
import com.project.core.persistence.entity.RolesEntity;

/**
 *
 * @author 19110
 */
public interface RolesDao extends GenericDao<Integer, RolesEntity> {
    List<RolesEntity> findByRoles(List<String> roles);
}
