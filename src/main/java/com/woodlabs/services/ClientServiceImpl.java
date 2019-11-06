package com.woodlabs.services;

import com.woodlabs.dto.ClientDto;
import com.woodlabs.entities.Client;
import com.woodlabs.repositories.ClientRepository;
import com.woodlabs.utils.Mapper;
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
    private ClientRepository clientRepository;

    @Override
    public ClientDto add(ClientDto clientDto) {
        Client client = Mapper.toClient(clientDto);
        Client saved = clientRepository.save(client);
        ClientDto dto = Mapper.toClientDto(saved);
        return dto;
    }

    @Override
    public void delete(ClientDto clientDto) {
        Client client;
        try {
            client = Mapper.toClient(clientDto);
            clientRepository.delete(client);
            return;
        }
        catch (Exception e) {
            log.warn("error deleting client {}", clientDto);
        }
    }

    @Override
    public ClientDto update(ClientDto clientDto) {
        Client client = Mapper.toClient(clientDto);
        Client saved = clientRepository.save(client);
        ClientDto dto = Mapper.toClientDto(client);
        return dto;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClientDto> findAll() {
        try {
            List<Client> found = clientRepository.findAll();
            List<ClientDto> dto = new LinkedList<>();
            for (Client client : found) {
                dto.add(Mapper.toClientDto(client));
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
            Optional<Client> clientOptional = clientRepository.findById(id);
            if(clientOptional.isPresent()){
                Client client = clientOptional.get();
                ClientDto dto = Mapper.toClientDto(client);
                return dto;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        log.warn("error searching client with id = {}", id);
        return null;
    }

}
