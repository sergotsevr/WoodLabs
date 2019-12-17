package com.woodlabs.dto;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class AddressDto {
    private Integer addressId;
    @Size(min = 3, max = 50)
    private String country;
    @Size(min = 3, max = 50)
    private String city;
    private Integer zipCode;
    @Size(min = 3, max = 100)
    private String street;
    private Integer building;
    private Integer apartments;

  /*  @Override
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
    }*/
}
