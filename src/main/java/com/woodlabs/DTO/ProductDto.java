package com.woodlabs.DTO;

import com.woodlabs.entities.enums.ProductCategory;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

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

    public int getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
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
