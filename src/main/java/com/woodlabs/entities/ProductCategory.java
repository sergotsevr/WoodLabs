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
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "characteristicsId")
    private List<Characteristics> characteristics;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    Product product;
}
