package com.woodlabs.dto;

import com.woodlabs.entities.Characteristics;
import com.woodlabs.entities.Product;
import lombok.Data;

import java.util.List;

@Data
public class ProductCategoryDto {
    private Integer productCategoryId;
    private String name;
    private Integer parentId;
    private List<Characteristics> characteristics;
    private Product product;
}
