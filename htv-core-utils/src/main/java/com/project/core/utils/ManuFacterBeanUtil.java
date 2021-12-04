/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.utils;

import com.project.core.dto.ManuFacterDTO;
import com.project.core.persistence.entity.ManuFacterEntity;

/**
 *
 * @author 19110
 */
public class ManuFacterBeanUtil {
    public static ManuFacterDTO entityToDto(ManuFacterEntity entity) {
        ManuFacterDTO dto = new ManuFacterDTO();
        dto.setManufacterId(entity.getManufacterId());
        dto.setManufacterName(entity.getManufacterName());
        return dto;
    }

    public static ManuFacterEntity dtoToEntity(ManuFacterDTO dto) {
        ManuFacterEntity entity = new ManuFacterEntity();
        entity.setManufacterId(dto.getManufacterId());
        entity.setManufacterName(dto.getManufacterName());
        return entity;
    }
}
