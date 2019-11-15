package com.woodlabs.services;

import com.woodlabs.entities.ProductCategory;
import com.woodlabs.repositories.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ProductCategoryServiceImpl {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    public ProductCategory findByName(String str){
        return productCategoryRepository.findByName(str);
    }
}
