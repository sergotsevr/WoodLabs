package com.woodlabs.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productCategoryId;
    @Column
    private String name;
    @Column
    private Integer parentId;
    @Column
    private String characteristics;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @Override
    public String toString() {
        return name ;
    }
}
