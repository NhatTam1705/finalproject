/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author 19110
 */
public class ProductImportDTO implements Serializable {
    private String productName;
    private String description;
    private String quantityLeft;
    private String manuFacter;
    private String price;
    private String style;
    private String rom;
    private String ram;
    private String discount;
    private boolean valid = true;
    private String error;

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

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    public String getManuFacter() {
        return manuFacter;
    }

    public void setManuFacter(String manuFacter) {
        this.manuFacter = manuFacter;
    }
    
}
