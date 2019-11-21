package com.woodlabs.entities;

import lombok.Data;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Entity
@Table
@Data
@Transactional
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer addressId;
    @Column
    private String country;
    @Column
    private String city;
    @Column
    private Integer zipCode;
    @Column
    private String street;
    @Column
    private Integer building;
    @Column
    private Integer apartments;

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", zipCode=" + zipCode +
                ", street='" + street + '\'' +
                ", building=" + building +
                ", apartments=" + apartments +
                '}';
    }
}
