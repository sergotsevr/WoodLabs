package com.woodlabs.services;

import com.woodlabs.entities.DTO.ProductDto;
import com.woodlabs.entities.Product;
import com.woodlabs.entities.enums.ProductCategory;
import com.woodlabs.repositories.ProductRepository;
import com.woodlabs.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product add(ProductDto productDto) {
        Product product = Mapper.toProduct(productDto);
        return product;
    }
}
