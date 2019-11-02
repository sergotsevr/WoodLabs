package com.woodlabs.dto;

import com.woodlabs.entities.ProductCategory;
import lombok.Data;

@Data
public class CharacteristicsDto {
    private Integer characteristicsId;
    private String characteristic;
    ProductCategory productCategory;
}
