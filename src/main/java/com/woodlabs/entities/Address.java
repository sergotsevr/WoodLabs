package com.woodlabs.entities;

import javax.persistence.*;

@Entity
@Table
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String country;
    @Column
    private String city;
    @Column
    private Integer zipCode;
    @Column
    private String street;
    @Column
    private Integer buidling;
    @Column
    private Integer apartments;

    public Address() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getBuidling() {
        return buidling;
    }

    public void setBuidling(Integer buidling) {
        this.buidling = buidling;
    }

    public Integer getApartments() {
        return apartments;
    }

    public void setApartments(Integer apartments) {
        this.apartments = apartments;
    }
}
