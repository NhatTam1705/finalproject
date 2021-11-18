/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.utils;

import com.project.core.dto.RolesDTO;
import com.project.core.persistence.entity.RolesEntity;

/**
 *
 * @author 19110
 */
public class RolesBeanUtil {
    public static RolesDTO entityToDto(RolesEntity entity) {
        RolesDTO dto = new RolesDTO();
        dto.setRoleId(entity.getRoleId());
        dto.setRoleName(entity.getRoleName());
        return dto;
    }

    public static RolesEntity dtoToEntity(RolesDTO dto) {
        RolesEntity entity = new RolesEntity();
        entity.setRoleId(dto.getRoleId());
        entity.setRoleName(dto.getRoleName());
        return entity;
    }
}
