package com.woodlabs.entities;


import com.woodlabs.entities.enums.Role;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.Set;

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
    @Column
    private Boolean active;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "client_clientId"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;



    public String setAddressId(Integer id) {
        try {
            if (address.getAddressId() != null) {
                address.setAddressId(id);
                return address.getAddressId().toString();
            }
        } catch (Exception e) {
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
        } catch (Exception e) {

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
