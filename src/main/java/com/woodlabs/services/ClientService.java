package com.woodlabs.services;

import com.woodlabs.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientService {

    @Autowired
    private ProductRepository productRepository;

}
