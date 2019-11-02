package com.woodlabs.dto;

import com.woodlabs.entities.Address;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientDto {

    private int clientId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    private Address address;

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
