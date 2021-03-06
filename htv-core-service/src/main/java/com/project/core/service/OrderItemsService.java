/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.service;

import java.util.List;
import java.util.Map;

import com.project.core.dto.OrderItemDTO;

/**
 *
 * @author 19110
 */
public interface OrderItemsService {
    Integer delete(List<Integer> ids);
    Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit);
    void saveOrderItem(OrderItemDTO orderItemDTO);
    OrderItemDTO findById(Integer orderItemId);
}
