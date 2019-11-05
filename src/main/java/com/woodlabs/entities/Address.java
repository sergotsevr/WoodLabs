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
    public String toString(){
        String address = "ID - ";
        address = address.concat(addressId.toString());
        address.concat(" Country - " + country);
        address.concat(" City - " + city);
        address.concat(" Zip code - " + zipCode);
        address.concat(" Street - " + street);
        address.concat(" Building - " + building);
        address.concat(" Apartments - " + apartments);
        return address;
    }
}
