/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.persistence.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author 19110
 */
@Entity
@Table(name = "manufacter")
public class ManuFacterEntity { 
    @Id
    @Column(name = "manufacter_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer manufacterId;

    @Column(name = "manufacter_name", nullable = false)
    private String manufacterName;

    @OneToMany(mappedBy = "manufacter", fetch = FetchType.LAZY)
    private List<ProductTypeEntity> productTypeEntityList;

    public Integer getManufacterId() {
        return manufacterId;
    }

    public void setManufacterId(Integer manufacterId) {
        this.manufacterId = manufacterId;
    }

    public String getManufacterName() {
        return manufacterName;
    }

    public void setManufacterName(String manufacterName) {
        this.manufacterName = manufacterName;
    }

    public List<ProductTypeEntity> getProductTypeEntityList() {
        return productTypeEntityList;
    }

    public void setProductTypeEntityList(List<ProductTypeEntity> productTypeEntityList) {
        this.productTypeEntityList = productTypeEntityList;
    }

    
}
