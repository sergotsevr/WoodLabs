package com.woodlabs.services.interfaces;

import com.woodlabs.dto.ProductCategoryDto;
import com.woodlabs.dto.ProductDto;
import com.woodlabs.entities.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    ProductCategory findByName(String str);

    ProductCategoryDto create(ProductCategoryDto ProductCategoryDto);

    void delete(ProductCategoryDto productCategoryDto);

    ProductCategoryDto update(ProductCategoryDto productCategoryDto);

    List<ProductCategoryDto> findAll();

    ProductCategoryDto findById(Integer id);

    void deleteById(Integer id);
}
