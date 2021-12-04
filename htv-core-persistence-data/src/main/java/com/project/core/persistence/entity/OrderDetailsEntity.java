/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.persistence.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 19110
 */
@Entity
@Table(name = "order_details")
public class OrderDetailsEntity {
    @Id
    @Column (name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsersEntity users;

    @Column (name = "total")
    private BigDecimal total = BigDecimal.ZERO;

    @Column (name = "created_date")
    private Timestamp createdDate;

    @OneToMany (mappedBy = "orderDetails", fetch = FetchType.LAZY)
    private List<OrderItemsEntity> orderItemsEntityList;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public UsersEntity getUser() {
        return users;
    }

    public void setUser(UsersEntity users) {
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

    public List<OrderItemsEntity> getOrderItemsEntityList() {
        return orderItemsEntityList;
    }

    public void setOrderItemsEntityList(List<OrderItemsEntity> orderItemsEntityList) {
        this.orderItemsEntityList = orderItemsEntityList;
    }
}
