package com.woodlabs.dto;

import com.woodlabs.entities.enums.Role;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Slf4j
public class ClientDto {

    private Integer clientId;
    @Size(min = 2, max = 100)
    private String firstName;
    @Size(min = 3, max = 100)
    private String lastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    @Email
    private String email;
    private String password;
    private AddressDto addressDto;
    private Set<Role> roles;
    private boolean active;
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
