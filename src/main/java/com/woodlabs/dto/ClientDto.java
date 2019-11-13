package com.woodlabs.dto;

import com.woodlabs.services.AddressService;
import com.woodlabs.utils.Util;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Slf4j
public class ClientDto {

    private Integer clientId;
    @NotBlank
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    private AddressDto addressDto;


    public String getAddressId(){
        try {
            if (addressDto.getAddressId() != null) {
                return addressDto.getAddressId().toString();
            }
        }
       catch (Exception e){
            e.printStackTrace();
           return "address is not specified";
        }
        return "address is not specified";
    }

    public ClientDto() {
    }


}
