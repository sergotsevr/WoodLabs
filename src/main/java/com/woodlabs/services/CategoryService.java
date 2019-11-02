package com.woodlabs.services;

import com.woodlabs.dto.ProductCategoryDto;

import java.util.List;

public interface CategoryService {
    public ProductCategoryDto add(ProductCategoryDto clientDto);
    public void delete(ProductCategoryDto clientDto);
    public ProductCategoryDto update(ProductCategoryDto clientDto);
    public List<ProductCategoryDto> findAll();
    public ProductCategoryDto findById(Integer id);
}
