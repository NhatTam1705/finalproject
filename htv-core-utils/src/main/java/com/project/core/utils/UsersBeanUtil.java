/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.utils;

import com.project.core.dto.UsersDTO;
import com.project.core.persistence.entity.UsersEntity;

/**
 *
 * @author 19110
 */
public class UsersBeanUtil {
    public static UsersDTO entityToDto(UsersEntity entity) {
        UsersDTO dto = new UsersDTO();
        dto.setUserId(entity.getUserId());
        dto.setPassword(entity.getPassword());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setAddress(entity.getAddress());
        dto.setTelephone(entity.getTelephone());
        dto.setEmail(entity.getEmail());
        dto.setRolesDTO(RolesBeanUtil.entityToDto(entity.getRoles()));
        dto.setCreateDate(entity.getCreateDate());
        dto.setModifiedDate(entity.getModifiedDate());
        return dto;
    }

    public static UsersEntity dtoToEntity(UsersDTO dto) {
        UsersEntity entity = new UsersEntity();
        entity.setUserId(dto.getUserId());
        entity.setPassword(dto.getPassword());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setAddress(dto.getAddress());
        entity.setTelephone(dto.getTelephone());
        entity.setEmail(dto.getEmail());
        entity.setRoles(RolesBeanUtil.dtoToEntity(dto.getRolesDTO()));
        entity.setCreateDate(dto.getCreateDate());
        entity.setModifiedDate(dto.getModifiedDate());
        return entity;
    }
}
