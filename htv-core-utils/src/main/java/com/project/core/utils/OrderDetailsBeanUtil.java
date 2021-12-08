/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.utils;

import com.project.core.dto.OrderDetailsDTO;
import com.project.core.persistence.entity.OrderDetailsEntity;

/**
 *
 * @author 19110
 */
public class OrderDetailsBeanUtil {
    public static OrderDetailsDTO entityToDto(OrderDetailsEntity entity) {
        OrderDetailsDTO dto = new OrderDetailsDTO();
        dto.setOrderId(entity.getOrderId());
        dto.setUsers(UsersBeanUtil.entityToDto(entity.getUser()));
        dto.setTotal(entity.getTotal());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }

    public static OrderDetailsEntity dtoToEntity(OrderDetailsDTO dto) {
        OrderDetailsEntity entity = new OrderDetailsEntity();
        entity.setOrderId(dto.getOrderId());
        entity.setUser(UsersBeanUtil.dtoToEntity(dto.getUsers()));
        entity.setTotal(dto.getTotal());
        entity.setCreatedDate(dto.getCreatedDate());
        return entity;
    }
}
