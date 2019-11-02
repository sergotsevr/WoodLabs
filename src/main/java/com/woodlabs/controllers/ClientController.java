package com.woodlabs.controllers;

import com.woodlabs.dto.AddressDto;
import com.woodlabs.dto.ClientDto;
import com.woodlabs.entities.Address;
import com.woodlabs.repositories.AddressRepository;
import com.woodlabs.services.AddressService;
import com.woodlabs.services.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
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
    AddressService addressService;
    @Autowired
    ClientService clientService;
    @Autowired
    private ModelMapper modelMapper;
    @GetMapping
    public String main(){
        return "clientMain";
    }
    @GetMapping("test")
    public String test( Model model) {
        ClientDto clientDto = new ClientDto();
        clientDto.setDateOfBirth(LocalDate.now());
        clientDto.setEmail("ElizabethWilliams@guts.com");
        clientDto.setFirstName("Jack");
        clientDto.setLastName("Ripper");
        AddressDto addressDto = new AddressDto();
        addressDto.setApartments(14);
        addressDto.setBuilding(23);
        addressDto.setStreet("Second st.");
        addressDto=addressService.add(addressDto);
        Address address = modelMapper.map(addressDto, Address.class);
        clientDto.setAddress(address);
        clientDto = clientService.add(clientDto);
        clientDto.setEmail("boombom");
        clientService.update(clientDto);
        return "congrat";
    }
}
