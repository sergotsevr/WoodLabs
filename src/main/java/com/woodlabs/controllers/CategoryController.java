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

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/admin/category")
@Slf4j
public class CategoryController {
    @Autowired
    ProductCategoryService productCategoryService;

    @GetMapping()
    public String main(Model model) {
        List<ProductCategoryDto> categories = productCategoryService.findAll();
        model.addAttribute("productCategories", categories);
        Map<Integer,String> parentNames = new LinkedHashMap<>();
        for (ProductCategoryDto productCategoryDto : categories){
            if (productCategoryDto.getParentId()!=null){
                parentNames.put(productCategoryDto.getProductCategoryId(),productCategoryService.findById(productCategoryDto.getParentId()).getName());
            }
            else {
                parentNames.put(productCategoryDto.getProductCategoryId(), "this is the root element");
            }
        }
        model.addAttribute("parentNames", parentNames);
        return "productCategory/productCategoryMain";
    }
    @GetMapping("/create")
    public String create(Model model){
        List<ProductCategoryDto> all = productCategoryService.findAll();
        List<ProductCategoryDto> root = new ArrayList<>();
        for (ProductCategoryDto productCategoryDto : all){
            if (productCategoryDto.getParentId() == null){
                root.add(productCategoryDto);
            }
        }
        model.addAttribute("root", root);
        return "productCategory/productCategoryCreate";
    }
    @PostMapping("/create")
    public String create(ProductCategoryDto productCategoryDto, Model model) {
        productCategoryService.create(productCategoryDto);
        return "redirect:";
    }
    @GetMapping("/update")
    public String update(Integer id, Model model){
        List<ProductCategoryDto> all = productCategoryService.findAll();
        List<ProductCategoryDto> root = new ArrayList<>();
        for (ProductCategoryDto productCategoryDto : all){
            if (productCategoryDto.getParentId() == null){
                root.add(productCategoryDto);
            }
        }
        model.addAttribute("root", root);
        ProductCategoryDto productCategoryDto = productCategoryService.findById(id);
        model.addAttribute("parent", productCategoryService.findById(productCategoryDto.getParentId()));
        model.addAttribute("category", productCategoryDto);
        return "productCategory/productCategoryUpdate";
    }
    @PostMapping("/update")
    public String update(ProductCategoryDto productCategoryDto, Model model) {
        productCategoryService.update(productCategoryDto);
        return "redirect:";
    }
    @GetMapping("/delete")
    public String delete(Integer id, Model model) {
       // Boolean errors=false;
        try{
            productCategoryService.deleteById(id);

        }
        catch (Exception e){
            model.addAttribute("error", "Error deleting category with id = " + id + ". Product with this category still exists");
        }
        List<ProductCategoryDto> clients = productCategoryService.findAll();
        model.addAttribute("productCategories", clients);
        return "productCategory/productCategoryMain";
    }
}
