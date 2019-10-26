package com.woodlabs.controllers;

import com.woodlabs.entities.Address;
import com.woodlabs.entities.Client;
import com.woodlabs.entities.DTO.ProductDto;
import com.woodlabs.entities.Order;
import com.woodlabs.entities.Product;
import com.woodlabs.entities.enums.ProductCategory;
import com.woodlabs.repositories.AddressRepository;
import com.woodlabs.repositories.ClientRepository;
import com.woodlabs.repositories.OrderRepository;
import com.woodlabs.repositories.ProductRepository;
import com.woodlabs.services.ProductService;
import com.woodlabs.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/product")
public class MainController {

    @Autowired
    ProductService productService;
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {

        Product product = new Product();
        product.setName("cereals");
        product.setPrice(343);
        product.setProductCategory(ProductCategory.GROCERY);
        product.setQuantityInStock(23432);
        product.setVolume(324);
        product.setWeight(234);
        ProductDto productDto = Mapper.toProductDto(product);

        productService.add(productDto);
       /* Product product = new Product();
        product.setName("butter");
        product.setPrice(344);
        product.setProductCategory(ProductCategory.GROCERY);
        product.setQuantityInStock(500);
        product.setVolume(3);
        product.setWeight(500);
        productRepository.save(product);
        model.addAttribute("name", name);*/
        return "greeting";
    }
    @GetMapping("/action_page")
    public String addOdrer(@RequestParam Map<String,String> allRequestParams, Model model){

/*
        Product product = new Product();
        product.setName("butter");
        product.setPrice(344);
        product.setProductCategory(ProductCategory.GROCERY);
        product.setQuantityInStock(500);
        product.setVolume(3);
        product.setWeight(500);
        productRepository.save(product);
        List <Product> productList = new ArrayList<>();
        productList.add(product);
        Client client = new Client();
        client.setDateOfBirth(LocalDate.now());
        client.setEmail("ElizabethWilliams@guts.com");
        client.setFirstName("Jack");
        client.setLastName("Ripper");
        clientRepository.save(client);
        Address address = new Address();
        address.setApartments(14);
        address.setBuilding(23);
        address.setCity("LA");
        address.setZipCode(3124);
        address.setCountry("USA");
        address.setStreet("Second st.");
        addressRepository.save(address);
        Order order = new Order();
        //Order order2 = new Order();
        order.setGoodsList(productList);
        order.setClient(client);
        order.setAddress(address);
        /*order.setOrderId(1);
        order2.setOrderId(2);
        //order2.setAddress(address);
        orderRepository.save(order);
        //orderRepository.save(order2);*/
        return "congrat";
    }


}