package com.woodlabs.entities;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Collection;
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
   /* @JoinTable(name = "productCharacteristics",
            joinColumns = @JoinColumn(name = "product_category_Id"),
            inverseJoinColumns = @JoinColumn(name = "characteristic_id")
    )*/
   @JoinColumn(name = "characteristicsId")
    private List<Characteristics> characteristics;
   /* @OneToMany(fetch = FetchType.EAGER, targetEntity = Characteristics.class)
   // @JoinColumn(name = "characteristicsId")
    @Fetch(value = FetchMode.SELECT)
    private List<Characteristics> characteristics;*/
}
