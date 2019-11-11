package com.woodlabs.entities;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;

@Entity
@Table
@Data
@Transactional
@Slf4j
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer clientId;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private LocalDate dateOfBirth;
    @Column
    private String email;
    @Column
    private String password;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AddressId")
    private Address address;

    public String setAddressId(Integer id){
        try {
            if (address.getAddressId() != null) {
                address.setAddressId(id);
                return address.getAddressId().toString();
            }
        }
        catch (Exception e){
            return "address is not specified";
        }
        return "address is not specified";
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }
    public void setClientId(String clientId) {
        try {
            this.clientId = Integer.parseInt(clientId);
        }
        catch (Exception e){

        }
    }
    public Client() {
    }

    public Client(String firstName, String lastName, LocalDate dateOfBirth, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;
    }


}
