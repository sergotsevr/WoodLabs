package com.woodlabs.controllers;

import com.woodlabs.dto.ClientDto;
import com.woodlabs.entities.Address;
import com.woodlabs.repositories.AddressRepository;
import com.woodlabs.services.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping(path = "/client")
@Slf4j
public class ClientController {

    @Autowired
    AddressRepository addressRepository;
    @Autowired
    ClientService clientService;

    @GetMapping("test")
    public String test( Model model) {
        ClientDto clientDto = new ClientDto();
        clientDto.setDateOfBirth(LocalDate.now());
        clientDto.setEmail("ElizabethWilliams@guts.com");
        clientDto.setFirstName("Jack");
        clientDto.setLastName("Ripper");
        clientService.add(clientDto);
        Address address = new Address();
        address.setApartments(14);
        address.setBuilding(23);
        address.setStreet("Second st.");
        clientDto.setAddress(addressRepository.save(address));
        return "congrat";
    }
}
