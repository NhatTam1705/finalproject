/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 *
 * @author 19110
 */
public class ProductDTO implements Serializable {
    private Integer productId;
    private String productName;
    private String description;
    private String quantityLeft;
    private ManuFacterDTO manuFacterDTO;
    private String price;
    private String style;
    private String rom;
    private String ram;
    private DiscountDTO discountDTO;
    private Timestamp createdDate;
    private Timestamp modifiedDate;
    private String image;

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

    public DiscountDTO getDiscountDTO() {
        return discountDTO;
    }

    public void setDiscountDTO(DiscountDTO discountDTO) {
        this.discountDTO = discountDTO;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    public ManuFacterDTO getManuFacterDTO() {
        return manuFacterDTO;
    }

    public void setManuFacterDTO(ManuFacterDTO manuFacterDTO) {
        this.manuFacterDTO = manuFacterDTO;
    }
    
}
