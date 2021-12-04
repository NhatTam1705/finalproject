/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.utils;

import com.project.core.dto.ProductDTO;
import com.project.core.persistence.entity.ProductEntity;

/**
 *
 * @author 19110
 */
public class ProductBeanUtil {
    public static ProductDTO entityToDto(ProductEntity entity) {
        ProductDTO dto = new ProductDTO();
        dto.setProductId(entity.getProductId());
        dto.setProductName(entity.getProductName());
        dto.setDescription(entity.getDescription());
        dto.setQuantityLeft(entity.getQuantityLeft());
        dto.setManuFacterDTO(ManuFacterBeanUtil.entityToDto(entity.getManufacter()));
        dto.setPrice(entity.getPrice());
        dto.setStyle(entity.getStyle());
        dto.setRom(entity.getRom());
        dto.setRam(entity.getRam());
        dto.setDiscountDTO(DiscountBeanUtil.entityToDto(entity.getDiscount()));
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setModifiedDate(entity.getModifiedDate());
        dto.setImage(entity.getImage());
        return dto;
    }

    public static ProductEntity dtoToEntity(ProductDTO dto) {
        ProductEntity entity = new ProductEntity();
        entity.setProductId(dto.getProductId());
        entity.setProductName(dto.getProductName());
        entity.setDescription(dto.getDescription());
        entity.setQuantityLeft(dto.getQuantityLeft());
        entity.setManufacter(ManuFacterBeanUtil.dtoToEntity(dto.getManuFacterDTO()));
        entity.setPrice(dto.getPrice());
        entity.setStyle(dto.getStyle());
        entity.setRom(dto.getRom());
        entity.setRam(dto.getRam());
        entity.setDiscount(DiscountBeanUtil.dtoToEntity(dto.getDiscountDTO()));
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setModifiedDate(dto.getModifiedDate());
        entity.setImage(dto.getImage());
        return entity;
    }
}
