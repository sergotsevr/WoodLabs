package com.woodlabs.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    String firstName;
    @Column
    String lastName;
    @Column
    LocalDate dateOfBirth;
    @Column
    String email;
    @Column
    String password;
    @Column
    Address address;
}
