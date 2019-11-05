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
