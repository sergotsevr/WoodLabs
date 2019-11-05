package com.woodlabs.services;

import com.woodlabs.dto.ClientDto;
import com.woodlabs.entities.Client;
import com.woodlabs.repositories.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Transactional
@Component
@Slf4j
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientDto add(ClientDto clientDto) {
        System.out.println(clientDto);
        Client client = modelMapper.map(clientDto, Client.class);
        Client saved = clientRepository.save(client);
        ClientDto dto = modelMapper.map(saved, ClientDto.class);
        return dto;
    }

    @Override
    public void delete(ClientDto clientDto) {
        Client client;
        try {
            client = convertToEntity(clientDto);
            clientRepository.delete(client);
            return;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        log.warn("error deleting client {}", clientDto);
    }

    @Override
    public ClientDto update(ClientDto clientDto) {
        Client client = modelMapper.map(clientDto, Client.class);
        Client saved = clientRepository.save(client);
        ClientDto dto = modelMapper.map(saved, ClientDto.class);
        return dto;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClientDto> findAll() {
        try {
            List<Client> found = clientRepository.findAll();
            List<ClientDto> dto = new LinkedList<>();
            for (Client client : found) {
                dto.add(modelMapper.map(client, ClientDto.class));
            }
            return dto;
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.warn("error finding all clients");
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public ClientDto findById(Integer id) {
        try {
            Optional<Client> client = clientRepository.findById(id);
            ClientDto dto = modelMapper.map(client, ClientDto.class);
            return dto;
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.warn("error searching client with id = {}", id);
        return null;
    }

    private Client convertToEntity(ClientDto clientDto) throws ParseException {
        Client client = modelMapper.map(clientDto, Client.class);
        return client;
    }
}
