/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.utils;

import com.project.core.dto.OrderItemDTO;
import com.project.core.persistence.entity.OrderItemsEntity;

/**
 *
 * @author 19110
 */
public class OrderItemsBeanUtil {
    public static OrderItemDTO entityToDto(OrderItemsEntity entity) {
        OrderItemDTO dto = new OrderItemDTO();
        dto.setOrderItemId(entity.getOrderItemId());
        dto.setOrderDetails(OrderDetailsBeanUtil.entityToDto(entity.getOrder()));
        dto.setProduct(ProductBeanUtil.entityToDto(entity.getProduct()));
        dto.setQuantity(entity.getQuantity());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }

    public static OrderItemsEntity dtoToEntity(OrderItemDTO dto) {
        OrderItemsEntity entity = new OrderItemsEntity();
        entity.setOrderItemId(dto.getOrderItemId());
        entity.setOrder(OrderDetailsBeanUtil.dtoToEntity(dto.getOrderDetails()));
        entity.setProduct(ProductBeanUtil.dtoToEntity(dto.getProduct()));
        entity.setQuantity(dto.getQuantity());
        entity.setCreatedDate(dto.getCreatedDate());
        return entity;
    }
}
