package com.woodlabs.entities;

import com.woodlabs.entities.enums.ProductCategory;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;
    @Column
    @NotEmpty
    private String name;
    @Column
    @Digits(integer = 10, fraction = 0)
    @NotNull
    private Integer price;
    @Column
    private ProductCategory productCategory;
    @Column
    @Digits(integer = 10, fraction = 0)
    private Integer weight;
    @Column
    @Digits(integer = 10, fraction = 0)
    private Integer volume;
    @Column
    @Digits(integer = 10, fraction = 0)
    private Integer quantityInStock;

    public Product() {
    }

    public Integer getProductId() {
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
