package com.woodlabs.controllers;

import com.woodlabs.dto.ProductCategoryDto;
import com.woodlabs.services.interfaces.ProductCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/admin/category")
@Slf4j
public class CategoryController {
    @Autowired
    ProductCategoryService productCategoryService;

    @GetMapping
    public String main(Model model) {
        List<ProductCategoryDto> clients = productCategoryService.findAll();
        model.addAttribute("clients", clients);
        return "productCategory/productCategoryMain";
    }
    @PostMapping("/create")
    public String create(ProductCategoryDto productCategoryDto, Model model) {
        productCategoryService.create(productCategoryDto);
        return "redirect:";
    }
}
