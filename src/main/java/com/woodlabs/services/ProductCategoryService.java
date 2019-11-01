package com.woodlabs.services;

import com.woodlabs.entities.ProductCategory;

public interface ProductCategoryService {

    static ProductCategory findByName(String str){return new ProductCategory();};
}
