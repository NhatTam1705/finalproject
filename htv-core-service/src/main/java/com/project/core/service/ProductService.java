/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.service;

import java.util.List;
import java.util.Map;

import com.project.core.dto.ProductDTO;
import com.project.core.dto.ProductImportDTO;

/**
 *
 * @author 19110
 */
public interface ProductService {
    Integer delete(List<Integer> ids);
    Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit);
    ProductDTO findById(Integer productId);
    void saveProduct(ProductDTO productDTO);
    ProductDTO updateProduct(ProductDTO productDTO);
    void validateImportProduct(List<ProductImportDTO> productImportDTOS);
    void saveProductImport(List<ProductImportDTO> productImportDTOS);
}
