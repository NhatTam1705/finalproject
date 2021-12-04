/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.command;

import java.util.List;

import com.project.core.dto.DiscountDTO;
import com.project.core.dto.ManuFacterDTO;
import com.project.core.dto.ProductDTO;
import com.project.core.dto.ProductImportDTO;
import com.project.core.web.command.AbstractCommand;

/**
 *
 * @author 19110
 */
public class ProductCommand extends AbstractCommand<ProductDTO>{
    public ProductCommand() {
        this.pojo = new ProductDTO();
    }

    private List<DiscountDTO> discounts;
    private Integer discountId;
    private List<ManuFacterDTO> manuFacters;
    private Integer manuFacterId;
    private List<ProductImportDTO> productImportDTOS;

    public List<DiscountDTO> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<DiscountDTO> discounts) {
        this.discounts = discounts;
    }

    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    public List<ManuFacterDTO> getManuFacters() {
        return manuFacters;
    }

    public void setManuFacters(List<ManuFacterDTO> manuFacters) {
        this.manuFacters = manuFacters;
    }

    public Integer getManuFacterId() {
        return manuFacterId;
    }

    public void setManuFacterId(Integer manuFacterId) {
        this.manuFacterId = manuFacterId;
    }

    public List<ProductImportDTO> getProductImportDTOS() {
        return productImportDTOS;
    }

    public void setProductImportDTOS(List<ProductImportDTO> productImportDTOS) {
        this.productImportDTOS = productImportDTOS;
    }


}
