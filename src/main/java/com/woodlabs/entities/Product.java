package com.woodlabs.entities;

import com.woodlabs.entities.enums.ProductCategory;

import javax.persistence.*;

@Entity
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    String name;
    @Column
    Integer price;
    @Column
    ProductCategory productCategory;
    @Column
    Integer weight;
    @Column
    Integer volume;
    @Column
    Integer quantityInStock;
}
