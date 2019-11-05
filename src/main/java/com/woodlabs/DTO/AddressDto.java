package com.woodlabs.dto;

import lombok.Data;

@Data
public class AddressDto {
    private Integer addressId;
    private String country;
    private String city;
    private Integer zipCode;
    private String street;
    private Integer building;
    private Integer apartments;

    @Override
    public String toString(){
        return addressId.toString();
    }
}
