package com.woodlabs.controllers;

import com.woodlabs.entities.Product;
import com.woodlabs.entities.ProductCategory;
import org.springframework.http.MediaType;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class TestController {

    @GetMapping("/test")
    public String test(Model model){
        ArrayList<Product> products = new ArrayList<>();
        Product product = new Product();
        product.setName("test");
        products.add(product);
        model.addAttribute("products", products);
        return "test/test";
    }
    @PostMapping("/test")
    public String test(@RequestParam("products") Product[] products, Model model){
        System.out.println(products[0].getName());
        return "test/test";
    }
}
