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

    @GetMapping()
    public String main(Model model) {
        List<ProductCategoryDto> clients = productCategoryService.findAll();
        model.addAttribute("productCategories", clients);
        return "productCategory/productCategoryMain";
    }
    @GetMapping("/create")
    public String create(){
        return "productCategory/productCategoryCreate";
    }
    @PostMapping("/create")
    public String create(ProductCategoryDto productCategoryDto, Model model) {
        productCategoryService.create(productCategoryDto);
        return "redirect:";
    }
    @GetMapping("/delete")
    public String delete(Integer id, Model model) {
       // Boolean errors=false;
        try{
            productCategoryService.deleteById(id);
        }
        catch (Exception e){
            model.addAttribute("error", "product with this category still exists");
        }
        return "redirect:";
    }
}
