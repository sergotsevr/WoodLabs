package com.woodlabs.services;

import com.woodlabs.dto.ClientDto;
import com.woodlabs.entities.Client;
import com.woodlabs.repositories.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class ClientService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ClientRepository clientRepository;

    public ClientDto add(ClientDto clientDto) {
        Client client = null;
        try {
            client = convertToEntity(clientDto);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Client saved = clientRepository.save(client);
       ClientDto dto = modelMapper.map(saved, ClientDto.class);
       return dto;
    }
    private Client convertToEntity(ClientDto clientDto) throws ParseException {
        Client client = modelMapper.map(clientDto, Client.class);
        return client;
    }
}
