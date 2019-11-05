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

    public ClientDto(int clientId, String firstName, String lastName, LocalDate dateOfBirth, String email, String password) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;
    }
}
