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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author 19110
 */
@Entity
@Table(name = "product_type")
public class ProductTypeEntity {
    @Id
    @Column (name = "product_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productTypeId;

    @Column(name = "product_type_name", nullable = false)
    private String productTypeName;

    @ManyToOne
    @JoinColumn(name = "manufacter_id", nullable = false)
    private ManuFacterEntity manufacter;

    @OneToMany(mappedBy = "productType", fetch = FetchType.LAZY)
    private List<ProductEntity> productEntityList;

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public ManuFacterEntity getManufacter() {
        return manufacter;
    }

    public void setManufacter(ManuFacterEntity manufacter) {
        this.manufacter = manufacter;
    }

    public List<ProductEntity> getProductEntityList() {
        return productEntityList;
    }

    public void setProductEntityList(List<ProductEntity> productEntityList) {
        this.productEntityList = productEntityList;
    }
}
