package com.woodlabs.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;
    @Column
    @NotEmpty
    private String name;
    @Column
    @Digits(integer = 10, fraction = 0)
    @NotNull
    private Integer price;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product")
    private ProductCategory productCategory;
    @Column
    @Digits(integer = 10, fraction = 0)
    private Integer weight;
    @Column
    @Digits(integer = 10, fraction = 0)
    private Integer volume;
    @Column
    @Digits(integer = 10, fraction = 0)
    private Integer quantityInStock;


    @Override
    public String toString(){
        String product = "ID - ";
        product = product.concat(this.productId.toString());
        product = product.concat(" навание - ");
        product = product.concat(this.name);
        product = product.concat(" цена - ");
        product = product.concat(this.price.toString());
        product = product.concat(" категория - ");
      //  product = product.concat(this.productCategory.toString());
        product = product.concat(" остаток на склае - ");
        product = product.concat(this.quantityInStock.toString());
        product = product.concat(" объем - ");
        product = product.concat(this.volume.toString());
        product = product.concat(" вес - ");
        product = product.concat(this.weight.toString());
        return product;
    }
}
