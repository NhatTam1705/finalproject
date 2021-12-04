/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.project.core.dto.DiscountDTO;
import com.project.core.persistence.entity.DiscountEntity;
import com.project.core.service.DiscountService;
import com.project.core.service.util.SingletonDaoUtil;
import com.project.core.utils.DiscountBeanUtil;

/**
 *
 * @author 19110
 */
public class DiscountServiceImpl implements DiscountService{
    public List<DiscountDTO> findAll() {
        List<DiscountEntity> entities = SingletonDaoUtil.getDiscountDaoInstance().findAll();
        List<DiscountDTO> dtos = new ArrayList<DiscountDTO>();   
        for (DiscountEntity item: entities) {
            DiscountDTO dto = DiscountBeanUtil.entityToDto(item);
            dtos.add(dto);
        } 
        return dtos;
    }
}
