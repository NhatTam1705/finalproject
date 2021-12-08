/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.project.core.dto.OrderDetailsDTO;
import com.project.core.persistence.entity.OrderDetailsEntity;
import com.project.core.service.OrderDetailsService;
import com.project.core.service.util.SingletonDaoUtil;
import com.project.core.utils.OrderDetailsBeanUtil;

/**
 *
 * @author 19110
 */
public class OrderDetailsServiceImpl implements OrderDetailsService{
    public Integer save(OrderDetailsDTO orderDetailsDTO) {
        Timestamp createdDate = new Timestamp(System.currentTimeMillis());
        orderDetailsDTO.setCreatedDate(createdDate);
        OrderDetailsEntity entity = OrderDetailsBeanUtil.dtoToEntity(orderDetailsDTO);
        return SingletonDaoUtil.getOrderDetailsDaoInstance().saveReturnId(entity);
    }
    public Integer delete(List<Integer> ids) {
        Integer result = SingletonDaoUtil.getOrderDetailsDaoInstance().delete(ids);
        return result;
    }
}
