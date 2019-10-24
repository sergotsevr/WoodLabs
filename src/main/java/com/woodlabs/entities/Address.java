package com.woodlabs.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Address {

    @Column
    String country;
    @Column
    String city;
    @Column
    Integer zipCode;
    @Column
    String street;
    @Column
    Integer buidling;
    @Column
    Integer apartments;
}
