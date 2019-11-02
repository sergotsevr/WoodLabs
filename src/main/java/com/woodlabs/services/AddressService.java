package com.woodlabs.services;

import com.woodlabs.dto.AddressDto;
import com.woodlabs.entities.Address;

import java.util.List;

public interface AddressService {
    public AddressDto add(AddressDto addressDto);
    public void delete(AddressDto addressDto);
    public AddressDto update(AddressDto addressDto);
    public List<AddressDto> findAll();
    public AddressDto findById(Integer id);
}
