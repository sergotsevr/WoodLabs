package com.woodlabs.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productCategory;
}
