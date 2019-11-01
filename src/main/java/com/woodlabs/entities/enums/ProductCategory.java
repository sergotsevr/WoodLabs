package com.woodlabs.entities.enums;


public enum ProductCategory {
    ELECTRIC("electric"),
    GROCERY("grocery");
    private final String productCategory;
    private ProductCategory(String productCategory){
        this.productCategory=productCategory;
    }
}
