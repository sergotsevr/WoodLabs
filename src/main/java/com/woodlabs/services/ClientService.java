package com.woodlabs.services;

import com.woodlabs.entities.Client;
import com.woodlabs.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientService {

    @Autowired
    private ClientRepository ClientRepository;


}
