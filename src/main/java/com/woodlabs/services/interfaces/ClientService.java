package com.woodlabs.services.interfaces;

import com.woodlabs.dto.ClientDto;
import com.woodlabs.entities.Client;
import java.util.List;

public interface ClientService {
    public ClientDto add(ClientDto clientDto);
    public void delete(ClientDto clientDto);
    public ClientDto update(ClientDto clientDto);
    public List<ClientDto> findAll();
    public ClientDto findById(Integer id);
}
