package com.woodlabs.services;

import com.woodlabs.dto.AddressDto;
import com.woodlabs.dto.ClientDto;
import com.woodlabs.entities.Address;
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
    private ModelMapper modelMapper;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressService addressService;
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
        }
        catch (Exception e) {
            log.warn("error deleting client {}", clientDto);
        }
    }

    @Override
    public ClientDto update(ClientDto clientDto) {
        try {
            if (addressService.findById(Integer.parseInt(clientDto.getAddressId())) != null) {
                clientDto.setAddressDto(addressService.findById(Integer.parseInt(clientDto.getAddressId())));
            }
        }
        catch (NumberFormatException e){
            log.warn("wrong id = {}", clientDto.getAddressId());
        }
        Client client = Mapper.toClient(clientDto);
        Client saved = clientRepository.save(client);
        ClientDto dto = Mapper.toClientDto(saved);
        return dto;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClientDto> findAll() {
        List<ClientDto> dto = null;

        try {
            dto = new LinkedList<>();
            List<Client> found = clientRepository.findAll();
            for (Client client : found) {
                dto.add(Mapper.toClientDto(client));
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("error finding all clients");
        }

        return dto;
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
