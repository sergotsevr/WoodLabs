package com.woodlabs.dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Data
@Slf4j
public class ClientDto {

    private Integer clientId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    private AddressDto addressDto;

    public String getAddressId(){
        try {
            if (addressDto.getAddressId() != null) {
                addressDto.getAddressId();
                return addressDto.getAddressId().toString();
            }
        }
       catch (Exception e){
           return "address is not specified";
        }
        return "address is not specified";
    }

    public ClientDto() {
    }


}
