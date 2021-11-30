/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.persistence.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 *
 * @author 19110
 */
@Entity
@Table(name = "payment_details")
public class PaymentDetailsEntity {
    @Id
    @Column (name = "payment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "provider")
    private String provider;

    @Column(name = "status")
    private String status;

    @Column(name = "create_date")
    private Timestamp createDate;

    @OneToMany (mappedBy = "paymentDetails", fetch = FetchType.LAZY)
    private List<OrderDetailsEntity> orderDetailsEntityList;

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public List<OrderDetailsEntity> getOrderDetailsEntityList() {
        return orderDetailsEntityList;
    }

    public void setOrderDetailsEntityList(List<OrderDetailsEntity> orderDetailsEntityList) {
        this.orderDetailsEntityList = orderDetailsEntityList;
    }

    
}
