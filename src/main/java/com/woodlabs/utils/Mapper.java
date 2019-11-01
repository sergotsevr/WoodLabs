package com.woodlabs.utils;

import com.woodlabs.DTO.ProductDto;
import com.woodlabs.entities.Product;

public class Mapper {
    public static Product toProduct(ProductDto productDto) {
        Product product = new Product();
        try {
            product.setProductId(productDto.getProductId());
        }
        catch (NullPointerException e){}
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setProductCategory(productDto.getProductCategory());
        product.setWeight(productDto.getWeight());
        product.setVolume(productDto.getVolume());
        product.setQuantityInStock(productDto.getQuantityInStock());
        return product;
    }

    public static ProductDto toProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setProductId(product.getProductId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setProductCategory(product.getProductCategory());
        productDto.setWeight(product.getWeight());
        productDto.setVolume(product.getVolume());
        productDto.setQuantityInStock(product.getQuantityInStock());
        return productDto;
    }
}
