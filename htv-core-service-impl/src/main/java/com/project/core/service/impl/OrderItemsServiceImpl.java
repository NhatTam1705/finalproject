/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.project.core.dto.OrderItemDTO;
import com.project.core.persistence.entity.OrderItemsEntity;
import com.project.core.service.OrderItemsService;
import com.project.core.service.util.SingletonDaoUtil;
import com.project.core.utils.OrderItemsBeanUtil;

/**
 *
 * @author 19110
 */
public class OrderItemsServiceImpl implements OrderItemsService{
    public Integer delete(List<Integer> ids) {
        Integer result = SingletonDaoUtil.getOrderItemsDaoInstance().delete(ids);
        return result;
    }

    public Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        Object[] objects = SingletonDaoUtil.getOrderItemsDaoInstance().findByProperty(property, sortExpression, sortDirection, offset, limit);
        List<OrderItemDTO> orderItemDTOs = new ArrayList<OrderItemDTO>();
        for (OrderItemsEntity item : (List<OrderItemsEntity>)objects[1]) {
            OrderItemDTO orderItemDTO = OrderItemsBeanUtil.entityToDto(item);
            orderItemDTOs.add(orderItemDTO);
        }
        objects[1] = orderItemDTOs;
        return objects;
    }

    public void saveOrderItem(OrderItemDTO orderItemDTO) {
        Timestamp createdDate = new Timestamp(System.currentTimeMillis());
        orderItemDTO.setCreatedDate(createdDate);
        OrderItemsEntity entity = OrderItemsBeanUtil.dtoToEntity(orderItemDTO);
        SingletonDaoUtil.getOrderItemsDaoInstance().save(entity);
    }
}
