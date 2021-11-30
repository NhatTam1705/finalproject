/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.persistence.entity;

import java.sql.Timestamp;
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
import javax.persistence.TemporalType;

/**
 *
 * @author 19110
 */
@Entity
@Table(name = "users")
public class UsersEntity {
    @Id
    @Column (name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    
    @Column (name = "password")
    private String password;

    @Column (name = "first_name")
    private String firstName;

    @Column (name = "last_name")
    private String lastName;

    @Column (name = "address")
    private String address;

    @Column (name = "telephone")
    private String telephone;

    @Column (name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RolesEntity roles;

    @Column (name = "create_date")
    private Timestamp createDate;

    @OneToMany (mappedBy = "users", fetch = FetchType.LAZY)
    private List<OrderDetailsEntity> orderDetailsEntityList;

    @OneToMany (mappedBy = "users", fetch = FetchType.LAZY)
    private List<ShoppingSessionEntity> shoppingSessionEntityList;
    
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public RolesEntity getRoles() {
        return roles;
    }

    public void setRoles(RolesEntity roles) {
        this.roles = roles;
    }

    public List<OrderDetailsEntity> getOrderDetailsEntityList() {
        return orderDetailsEntityList;
    }

    public void setOrderDetailsEntityList(List<OrderDetailsEntity> orderDetailsEntityList) {
        this.orderDetailsEntityList = orderDetailsEntityList;
    }

    public List<ShoppingSessionEntity> getShoppingSessionEntityList() {
        return shoppingSessionEntityList;
    }

    public void setShoppingSessionEntityList(List<ShoppingSessionEntity> shoppingSessionEntityList) {
        this.shoppingSessionEntityList = shoppingSessionEntityList;
    }
}
