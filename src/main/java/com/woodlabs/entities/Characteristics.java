package com.woodlabs.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Characteristics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer characteristicsId;
    @Column
    private String characteristic;
    @ManyToOne
    @JoinColumn(name = "product_Category_Id")
    ProductCategory productCategory;


}
