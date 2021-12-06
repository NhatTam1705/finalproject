/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.utils;

import java.math.BigDecimal;

import com.project.core.dto.DiscountDTO;
import com.project.core.persistence.entity.DiscountEntity;

/**
 *
 * @author 19110
 */
public class DiscountBeanUtil {
    public static DiscountDTO entityToDto(DiscountEntity entity) {
        DiscountDTO dto = new DiscountDTO();
        dto.setDiscountId(entity.getDiscountId());
        dto.setDiscountName(entity.getDiscountName());
        dto.setDescription(entity.getDescription());
        dto.setDiscountPercent(entity.getDiscountPercent());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }

    public static DiscountEntity dtoToEntity(DiscountDTO dto) {
        DiscountEntity entity = new DiscountEntity();
        entity.setDiscountId(dto.getDiscountId());
        entity.setDiscountName(dto.getDiscountName());
        entity.setDescription(dto.getDescription());
        entity.setDiscountPercent(dto.getDiscountPercent());
        entity.setCreatedDate(dto.getCreatedDate());
        return entity;
    }
}
