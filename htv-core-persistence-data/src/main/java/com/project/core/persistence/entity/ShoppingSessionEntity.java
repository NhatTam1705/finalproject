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
@Table(name = "shopping_session")
public class ShoppingSessionEntity {
    @Id
    @Column (name = "session_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sessionId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsersEntity users;

    @Column(name = "total")
    private BigDecimal total = BigDecimal.ZERO;

    @Column(name = "create_date")
    private Timestamp createDate;

    @OneToMany(mappedBy = "shoppingSession", fetch = FetchType.LAZY)
    private List<CartItemEntity> cartItemEntityList;

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
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

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public List<CartItemEntity> getCartItemEntityList() {
        return cartItemEntityList;
    }

    public void setCartItemEntityList(List<CartItemEntity> cartItemEntityList) {
        this.cartItemEntityList = cartItemEntityList;
    }
}
