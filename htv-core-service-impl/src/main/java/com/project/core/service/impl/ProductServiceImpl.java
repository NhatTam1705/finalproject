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
import com.project.core.persistence.entity.DiscountEntity;
import com.project.core.persistence.entity.ManuFacterEntity;
import com.project.core.persistence.entity.ProductEntity;
import com.project.core.service.ProductService;
import com.project.core.service.util.SingletonDaoUtil;
import com.project.core.utils.ProductBeanUtil;

import org.apache.commons.lang.StringUtils;
import org.hibernate.exception.ConstraintViolationException;

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

    public void saveProduct(ProductDTO productDTO) throws ConstraintViolationException {
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

    public ProductDTO findByProductId(String property, Integer productId) {
        ProductEntity entity = SingletonDaoUtil.getProductDaoInstance().findEqualUnique(property, productId);
        ProductDTO dto = ProductBeanUtil.entityToDto(entity);
        return dto;
    }
}
