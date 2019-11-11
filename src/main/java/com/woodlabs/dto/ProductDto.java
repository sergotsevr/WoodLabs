package com.woodlabs.dto;

import com.woodlabs.entities.ProductCategory;
import lombok.Data;

@Data
public class ProductDto {

    private Integer productId;
    private String name;
    private Integer price;
    private ProductCategory productCategory;
    private Integer weight;
    private Integer volume;
    private Integer quantityInStock;

    public ProductDto() {
    }

    public ProductDto(int productId, String name, Integer price, ProductCategory productCategory, Integer weight, Integer volume, Integer quantityInStock) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.productCategory = productCategory;
        this.weight = weight;
        this.volume = volume;
        this.quantityInStock = quantityInStock;
    }

    
    @Override
    public String toString(){
        String product = "ID - ";
        product = product.concat(this.productId.toString());
        product = product.concat(" навание - ");
        product = product.concat(this.name);
        product = product.concat(" цена - ");
        product = product.concat(this.price.toString());
        product = product.concat(" категория - ");
        product = product.concat(this.productCategory.toString());
        product = product.concat(" остаток на склае - ");
        product = product.concat(this.quantityInStock.toString());
        product = product.concat(" объем - ");
        product = product.concat(this.volume.toString());
        product = product.concat(" вес - ");
        product = product.concat(this.weight.toString());
        return product;
    }
}
