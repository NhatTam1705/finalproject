/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.project.core.dto.ManuFacterDTO;
import com.project.core.persistence.entity.ManuFacterEntity;
import com.project.core.service.ManuFacterService;
import com.project.core.service.util.SingletonDaoUtil;
import com.project.core.utils.ManuFacterBeanUtil;

/**
 *
 * @author 19110
 */
public class ManuFacterServiceImpl implements ManuFacterService{
    public List<ManuFacterDTO> findAll() {
        List<ManuFacterEntity> entities = SingletonDaoUtil.getManuFacterDaoInstance().findAll();
        List<ManuFacterDTO> dtos = new ArrayList<ManuFacterDTO>();   
        for (ManuFacterEntity item: entities) {
            ManuFacterDTO dto = ManuFacterBeanUtil.entityToDto(item);
            dtos.add(dto);
        } 
        return dtos;
    }
}
