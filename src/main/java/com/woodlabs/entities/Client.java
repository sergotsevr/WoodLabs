package com.woodlabs.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int clientId;
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
   // @Column
   // private Address address;

    public Client() {
    }

    public Client(String firstName, String lastName, LocalDate dateOfBirth, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int id) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   /* public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }*/
}
