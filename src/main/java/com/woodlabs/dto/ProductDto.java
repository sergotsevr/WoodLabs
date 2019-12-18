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
    private Integer categoryId;

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
    public String toString() {
        String product = "ID - ";
        product = product.concat(this.productId.toString());
        product = product.concat(" навание - ");
        product = product.concat(this.name);
        product = product.concat(" цена - ");
        if ((this.price != null)) {
            product = product.concat(this.price.toString());
        }
        else {
            product = product.concat("not specified");
        }
        product = product.concat(" категория - ");
        if ((this.productCategory != null)) {
            product = product.concat(this.productCategory.toString());
        }
        else {
            product = product.concat("not specified");
        }

        product = product.concat(" остаток на склае - ");
        if ((this.quantityInStock != null)) {
            product = product.concat(this.quantityInStock.toString());
        }
        else {
            product = product.concat("not specified");
        }
        product = product.concat(" объем - ");
        if ((this.volume != null)) {
            product = product.concat(this.volume.toString());
        }
        else {
            product = product.concat("not specified");
        }
        product = product.concat(" вес - ");
        if ((this.weight != null)) {
            product = product.concat(this.weight.toString());
        }
        else {
            product = product.concat("not specified");
        }

        return product;
    }
}
