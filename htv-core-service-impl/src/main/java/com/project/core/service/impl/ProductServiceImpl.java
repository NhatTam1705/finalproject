/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.core.dto.ProductDTO;
import com.project.core.dto.ProductImportDTO;
import com.project.core.persistence.entity.DiscountEntity;
import com.project.core.persistence.entity.ManuFacterEntity;
import com.project.core.persistence.entity.ProductEntity;
import com.project.core.service.ProductService;
import com.project.core.service.util.SingletonDaoUtil;
import com.project.core.utils.ProductBeanUtil;

import org.apache.commons.lang.StringUtils;

/**
 *
 * @author 19110
 */
public class ProductServiceImpl implements ProductService{
    public Integer delete(List<Integer> ids) {
        Integer result = SingletonDaoUtil.getProductDaoInstance().delete(ids);
        return result;
    }

    public Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        Object[] objects = SingletonDaoUtil.getProductDaoInstance().findByProperty(property, sortExpression, sortDirection, offset, limit);
        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        for (ProductEntity item : (List<ProductEntity>)objects[1]) {
            ProductDTO productDTO = ProductBeanUtil.entityToDto(item);
            productDTOs.add(productDTO);
        }
        objects[1] = productDTOs;
        return objects;
    }

    public ProductDTO findById(Integer productId) {
        ProductEntity entity = SingletonDaoUtil.getProductDaoInstance().findById(productId);
        ProductDTO dto = ProductBeanUtil.entityToDto(entity);
        return dto;
    }

    public void saveProduct(ProductDTO productDTO) {
        Timestamp createdDate = new Timestamp(System.currentTimeMillis());
        productDTO.setCreatedDate(createdDate);
        ProductEntity entity = ProductBeanUtil.dtoToEntity(productDTO);
        SingletonDaoUtil.getProductDaoInstance().save(entity);
    }

    public ProductDTO updateProduct(ProductDTO productDTO) {
        Timestamp modifiedDate = new Timestamp(System.currentTimeMillis());
        productDTO.setModifiedDate(modifiedDate);
        ProductEntity entity = ProductBeanUtil.dtoToEntity(productDTO);
        entity = SingletonDaoUtil.getProductDaoInstance().update(entity);
        productDTO = ProductBeanUtil.entityToDto(entity);
        return productDTO;
    }

    public void validateImportProduct(List<ProductImportDTO> productImportDTOS) {
        List<String> productNames = new ArrayList<String>();
        List<String> discounts = new ArrayList<String>();
        List<String> manuFacters = new ArrayList<String>();

        for(ProductImportDTO item: productImportDTOS) {
            if (item.isValid()) {
                productNames.add(item.getProductName());
                if (!discounts.contains(item.getDiscount())) {
                    discounts.add(item.getDiscount());
                }
                if (!manuFacters.contains(item.getManuFacter())) {
                    manuFacters.add(item.getManuFacter());
                }
            }
        }

        Map<String, ProductEntity> productEntityMap = new HashMap<String, ProductEntity>();
        Map<String, DiscountEntity> discountEntityMap = new HashMap<String, DiscountEntity>();
        Map<String, ManuFacterEntity> manuFacterEntityMap = new HashMap<String, ManuFacterEntity>();
        if (productNames.size() > 0) {
            List<ProductEntity> productEntities = SingletonDaoUtil.getProductDaoInstance().findByProducts(productNames);
            for (ProductEntity item: productEntities) {
                productEntityMap.put(item.getProductName().toUpperCase(), item);
            }
        }
        if (discounts.size() > 0) {
            List<DiscountEntity> discountEntities = SingletonDaoUtil.getDiscountDaoInstance().findByDiscounts(discounts);
            for (DiscountEntity item: discountEntities) {
                discountEntityMap.put(item.getDiscountName().toUpperCase(), item);
            }
        }
        if (manuFacters.size() > 0) {
            List<ManuFacterEntity> manuFacterEntities = SingletonDaoUtil.getManuFacterDaoInstance().findByManuFacters(manuFacters);
            for (ManuFacterEntity item: manuFacterEntities) {
                manuFacterEntityMap.put(item.getManufacterName().toUpperCase(), item);
            }
        }

        for (ProductImportDTO item: productImportDTOS) {
            String message = item.getError();
            if (item.isValid()) {
                ProductEntity productEntity = productEntityMap.get(item.getProductName().toUpperCase());
                if (productEntity != null) {
                    message += "<br/>";
                    message += "Product already exist.";
                }
                DiscountEntity discountEntity = discountEntityMap.get(item.getDiscount().toUpperCase());
                if (discountEntity == null) {
                    message += "<br/>";
                    message += "Discount does not exist.";
                }
                ManuFacterEntity manuFacterEntity = manuFacterEntityMap.get(item.getManuFacter().toUpperCase());
                if (manuFacterEntity == null) {
                    message += "<br/>";
                    message += "Manufacter type does not exist.";
                }
                if (StringUtils.isNotBlank(message)) {
                    item.setValid(false);
                    item.setError(message.substring(5));
                }
            }
        }
    }

    public void saveProductImport(List<ProductImportDTO> productImportDTOS) {
        for (ProductImportDTO item: productImportDTOS) {
            if (item.isValid()) {
                ProductEntity productEntity = new ProductEntity();
                productEntity.setProductName(item.getProductName());
                productEntity.setDescription(item.getDescription());
                productEntity.setQuantityLeft(item.getQuantityLeft());
                ManuFacterEntity manuFacterTypeEntity = SingletonDaoUtil.getManuFacterDaoInstance().findEqualUnique("manufacterName", item.getManuFacter().toUpperCase());
                productEntity.setManufacter(manuFacterTypeEntity);
                productEntity.setPrice(item.getPrice());
                productEntity.setStyle(item.getStyle());
                productEntity.setRom(item.getRom());
                productEntity.setRam(item.getRam());
                DiscountEntity discountEntity = SingletonDaoUtil.getDiscountDaoInstance().findEqualUnique("discountName", item.getDiscount().toUpperCase());
                productEntity.setDiscount(discountEntity);
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                productEntity.setCreatedDate(timestamp);
                SingletonDaoUtil.getProductDaoInstance().save(productEntity);
            }
        }
    }
}
