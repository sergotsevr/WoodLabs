package com.woodlabs.entities.controllers;

import com.woodlabs.entities.Address;
import com.woodlabs.entities.Order;
import com.woodlabs.entities.Product;
import com.woodlabs.entities.repositories.AddressRepository;
import com.woodlabs.entities.repositories.OrderRepository;
import com.woodlabs.entities.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private OrderRepository orderRepository;
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        Product product = new Product();
        product.setName("ohaio");
        productRepository.save(product);
        model.addAttribute("name", name);
        return "greeting";
    }
    @GetMapping("/action_page")
    public String addOdrer(@RequestParam(name = "param",required = false) String name, Model model){
        Address address = new Address();
        address.setApartments(14);
        address.setBuilding(23);
        address.setCity("LA");
        address.setZipCode(3124);
        address.setCountry("USA");
        address.setStreet("Second st.");
        addressRepository.save(address);
        Order order = new Order();
        Order order2 = new Order();
        order.setAddress(address);
        order.setOrderId(1);
        order2.setOrderId(2);
        order2.setAddress(address);
        orderRepository.save(order);
        orderRepository.save(order2);
        return "congrat";
    }


}