package com.woodlabs.form;

import com.woodlabs.entities.ProductCategory;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ProductForm {
    private Integer productId;
    @NotNull
    private String name;
    private Integer price;
    private ProductCategory productCategory;
    private Integer weight;
    private Integer volume;
    private Integer quantityInStock;
}
