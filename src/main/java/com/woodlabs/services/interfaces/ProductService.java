package com.woodlabs.services.interfaces;

import com.woodlabs.dto.ProductDto;
import com.woodlabs.entities.Product;

import java.util.List;

public interface ProductService {
    public Product add(ProductDto productDto);
    public void delete(ProductDto productDto);
    public ProductDto update(ProductDto productDto);
    public List<ProductDto> findAll();
    public ProductDto findById(Integer id);
}
