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
@Table(name = "product")
public class ProductEntity {
    @Id
    @Column (name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity_left")
    private String quantityLeft;

    @ManyToOne
    @JoinColumn(name = "manufacter_id")
    private ManuFacterEntity manufacter;

    @Column(name = "price")
    private String price;

    @Column(name = "style")
    private String style;

    @Column(name = "rom")
    private String rom;

    @Column(name = "ram")
    private String ram;

    @ManyToOne
    @JoinColumn(name = "discount_id")
    private DiscountEntity discount;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @Column (name = "modified_date")
    private Timestamp modifiedDate;

    @Column(name = "image")
    private String image;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<OrderItemsEntity> orderItemsEntityList;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantityLeft() {
        return quantityLeft;
    }

    public void setQuantityLeft(String quantityLeft) {
        this.quantityLeft = quantityLeft;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public DiscountEntity getDiscount() {
        return discount;
    }

    public void setDiscount(DiscountEntity discount) {
        this.discount = discount;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<OrderItemsEntity> getOrderItemsEntityList() {
        return orderItemsEntityList;
    }
    
    public void setOrderItemsEntityList(List<OrderItemsEntity> orderItemsEntityList) {
        this.orderItemsEntityList = orderItemsEntityList;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public ManuFacterEntity getManufacter() {
        return manufacter;
    }

    public void setManufacter(ManuFacterEntity manufacter) {
        this.manufacter = manufacter;
    }
    
}
