/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.project.core.dao.RolesDao;
import com.project.core.daoimpl.RolesDaoImpl;
import com.project.core.dto.RolesDTO;
import com.project.core.persistence.entity.RolesEntity;
import com.project.core.service.RolesService;
import com.project.core.service.util.SingletonDaoUtil;
import com.project.core.utils.RolesBeanUtil;

/**
 *
 * @author 19110
 */
public class RolesServiceImpl implements RolesService {
    public List<RolesDTO> findAll() {
        List<RolesEntity> entities = SingletonDaoUtil.getRolesDaoInstance().findAll();
        List<RolesDTO> dtos = new ArrayList<RolesDTO>();   
        for (RolesEntity item: entities) {
            RolesDTO dto = RolesBeanUtil.entityToDto(item);
            dtos.add(dto);
        } 
        return dtos;
    }
}
    

