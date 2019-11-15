package com.woodlabs.dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Slf4j
public class ClientDto {

    private Integer clientId;
    @NotBlank
    private String firstName;
    private String lastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    private AddressDto addressDto;


    public String getAddressId(){
        try {
            if (addressDto != null){
                return addressDto.getAddressId().toString();
            }
            else {
                return "address is not specified";
            }
        }
       catch (Exception e) {
           e.printStackTrace();
           return "error searching address";
       }
    }

    public ClientDto() {
    }


}
