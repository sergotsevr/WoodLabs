package com.woodlabs.entities;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;

@Entity
@Table
@Data
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
    @OneToOne
    @JoinColumn(name = "AddressId")
    private Address address;

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
