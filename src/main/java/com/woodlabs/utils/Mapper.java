package com.woodlabs.utils;

import com.woodlabs.dto.AddressDto;
import com.woodlabs.dto.ClientDto;
import com.woodlabs.dto.ProductDto;
import com.woodlabs.entities.Address;
import com.woodlabs.entities.Client;
import com.woodlabs.entities.Product;
import com.woodlabs.entities.ProductCategory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.rmi.RmiClientInterceptorUtils;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Mapper {



    public static Product toProduct(ProductDto productDto) {
        Product product = new Product();
        try {
            product.setProductId(productDto.getProductId());
        }
        catch (NullPointerException e){}
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setProductCategory(productDto.getProductCategory());
        product.setWeight(productDto.getWeight());
        product.setVolume(productDto.getVolume());
        product.setQuantityInStock(productDto.getQuantityInStock());

        if (productDto.getCategoryId() != null) {
            ProductCategory productCategory = new ProductCategory();
            productCategory.setProductCategoryId(productDto.getCategoryId());
            product.setProductCategory(productCategory);
        }
        return product;
    }

    public static ProductDto toProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setProductId(product.getProductId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setProductCategory(product.getProductCategory());
        productDto.setWeight(product.getWeight());
        productDto.setVolume(product.getVolume());
        productDto.setQuantityInStock(product.getQuantityInStock());
        return productDto;
    }
    public static ClientDto toClientDto(Client client) {
        ClientDto clientDto = new ClientDto();
        clientDto.setClientId(client.getClientId());
        clientDto.setFirstName(client.getFirstName());
        clientDto.setLastName(client.getLastName());
        clientDto.setDateOfBirth(client.getDateOfBirth());
        clientDto.setEmail(client.getEmail());
        clientDto.setPassword(client.getPassword());
        clientDto.setRoles(client.getRoles());
        clientDto.setActive(client.getActive());
        if (client.getAddress()!=null) {
            AddressDto addressDto = toAddressDto(client.getAddress());
            clientDto.setAddressDto(addressDto);
        }
        return clientDto;
    }
    public static Client toClient(ClientDto clientDto) {
        Client client = new Client();
        client.setClientId(clientDto.getClientId());
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setDateOfBirth(clientDto.getDateOfBirth());
        client.setEmail(clientDto.getEmail());
        client.setPassword(clientDto.getPassword());
        client.setActive(clientDto.getActive());
        client.setRoles(clientDto.getRoles());
        if (clientDto.getAddressDto()!=null) {
            Address address = toAddress(clientDto.getAddressDto());
            client.setAddress(address);
        }
        return client;
    }
    public static AddressDto toAddressDto(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setAddressId(address.getAddressId());
        addressDto.setCountry(address.getCountry());
        addressDto.setCity(address.getCity());
        addressDto.setZipCode(address.getZipCode());
        addressDto.setStreet(address.getStreet());
        addressDto.setBuilding(address.getBuilding());
        addressDto.setApartments(address.getApartments());
        return addressDto;
    }
    public static Address toAddress(AddressDto addressDto) {
        Address address = new Address();
        address.setAddressId(addressDto.getAddressId());
        address.setCountry(addressDto.getCountry());
        address.setCity(addressDto.getCity());
        address.setZipCode(addressDto.getZipCode());
        address.setStreet(addressDto.getStreet());
        address.setBuilding(addressDto.getBuilding());
        address.setApartments(addressDto.getApartments());
        return address;
    }
}
