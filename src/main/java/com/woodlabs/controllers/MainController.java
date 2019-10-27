package com.woodlabs.controllers;

import com.woodlabs.entities.DTO.ProductDto;
import com.woodlabs.entities.Product;
import com.woodlabs.entities.enums.ProductCategory;
import com.woodlabs.services.ProductService;
import com.woodlabs.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/product")
public class MainController {

    @Autowired
    ProductService productService;
    @PostMapping("/add")
    public ModelAndView add(@RequestParam Map<String,String> allRequestParams, Model model) {
        ProductDto productDto = new ProductDto();
        productDto.setName(allRequestParams.get("name"));
        productDto.setPrice(Integer.parseInt(allRequestParams.get("price")));
        productDto.setProductCategory(ProductCategory.valueOf(allRequestParams.get("productCategory")));
        productDto.setWeight(Integer.parseInt(allRequestParams.get("weight")));
        productDto.setVolume(Integer.parseInt(allRequestParams.get("volume")));
        productDto.setQuantityInStock(Integer.parseInt(allRequestParams.get("quantityInStock")));
        Product product = productService.add(productDto);
        model.addAttribute("product", product);
        return new ModelAndView("product", (Map<String, Product>) model);
    }

    @GetMapping("/find")
    public String find (@RequestParam(name="id") Integer id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "Product" ;
    }

    @GetMapping("/findAll")
    public ModelAndView findAll(@RequestParam Map<String,String> allRequestParams, Model model) {
        List<ProductDto> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return new ModelAndView("allProduct", (Map<String, Product>) model);
    }
    @GetMapping("/delete")
    public String delete(@RequestParam Integer id, Model model){
        ProductDto productDto = new ProductDto();
        productDto.setProductId(id);
        productService.delete(productDto);
        return "congrat";
    }

    @PostMapping("/update")
    public ModelAndView update(@RequestParam Map<String,String> allRequestParams, Model model) {
        ProductDto productDto = new ProductDto();
        productDto.setProductId(Integer.parseInt(allRequestParams.get("id")));
        productDto.setName(allRequestParams.get("name"));
        productDto.setPrice(Integer.parseInt(allRequestParams.get("price")));
        productDto.setProductCategory(ProductCategory.valueOf(allRequestParams.get("productCategory")));
        productDto.setWeight(Integer.parseInt(allRequestParams.get("weight")));
        productDto.setVolume(Integer.parseInt(allRequestParams.get("volume")));
        productDto.setQuantityInStock(Integer.parseInt(allRequestParams.get("quantityInStock")));
        Product product = productService.add(productDto);
        model.addAttribute("product", product);
        return new ModelAndView("product", (Map<String, Product>) model);
    }
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {


        return "update";
    }
    @GetMapping("/update")
    public String update(@RequestParam String str, Model model) {
        return "update";
    }
    @GetMapping("/add")
    public String add(@RequestParam String str, Model model) {

        return "update";
    }
}