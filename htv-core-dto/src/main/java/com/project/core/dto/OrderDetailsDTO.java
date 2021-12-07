/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author 19110
 */
public class OrderDetailsDTO implements Serializable {
    private Integer orderId;
    private UsersDTO users;
    private BigDecimal total;
    private Timestamp createdDate;
    private List<OrderItemDTO> orderItemsDTOList;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public UsersDTO getUsers() {
        return users;
    }

    public void setUsers(UsersDTO users) {
        this.users = users;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }
    
    public List<OrderItemDTO> getOrderItemsDTOList() {
        return orderItemsDTOList;
    }

    public void setOrderItemsDTOList(List<OrderItemDTO> orderItemsDTOList) {
        this.orderItemsDTOList = orderItemsDTOList;
    }
    
} 
