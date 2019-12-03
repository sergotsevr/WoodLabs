package com.woodlabs.services.implementation;

import com.woodlabs.dto.AddressDto;
import com.woodlabs.entities.Address;
import com.woodlabs.repositories.AddressRepository;
import com.woodlabs.services.interfaces.AddressService;
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
@Slf4j
@Component
public class AddressServiceImpl implements AddressService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public AddressDto add(AddressDto addressDto) {
        Address address;
        try {
            address = convertToEntity(addressDto);
            Address saved = addressRepository.save(address);
            AddressDto dto = modelMapper.map(saved, AddressDto.class);
            return dto;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        log.warn("error adding Address {}", addressDto);
        return null;
    }

    @Override
    public void delete(AddressDto addressDto) {
        Address address;
        try {
            address = convertToEntity(addressDto);
            addressRepository.delete(address);
            return;
        } catch (ParseException e) {

            log.error("Error while removing adress", e);
        }
        log.warn("error deleting Address {}", addressDto);
    }

    @Override
    public AddressDto update(AddressDto addressDto) {
        Address address;
        try {
            address = convertToEntity(addressDto);
            Address saved = addressRepository.save(address);
            AddressDto dto = modelMapper.map(saved, AddressDto.class);
            return dto;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        log.warn("error updating address {}", addressDto);
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<AddressDto> findAll() {
        try {
            List<Address> found = addressRepository.findAll();
            List<AddressDto> dto = new LinkedList<>();
            for (Address address:found) {
                dto.add(modelMapper.map(address, AddressDto.class));
            }
            return dto;
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.warn("error finding all address");
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public AddressDto findById(Integer id) {
        try {
            Optional<Address> address = addressRepository.findById(id);
            if(address.isPresent()) {
                Address address1 = address.get();
                AddressDto dto = modelMapper.map(address1, AddressDto.class);
                return dto;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.warn("error searching address with id = {}", id);
        return null;
    }

    private Address convertToEntity(AddressDto addressDto) throws ParseException {
        try {
            Address address = modelMapper.map(addressDto, Address.class);
            return address;
        }
        catch (Exception e){
            return null;
        }
    }
}
