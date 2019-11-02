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
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "productCategory")
    private List<Characteristics> characteristics;
    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "product_id")
    Product product;
}
