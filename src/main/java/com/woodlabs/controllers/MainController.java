package com.woodlabs.controllers;

import com.woodlabs.entities.DTO.ProductDto;
import com.woodlabs.entities.Product;
import com.woodlabs.entities.enums.ProductCategory;
import com.woodlabs.services.ProductService;
import com.woodlabs.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping(path = "/product")
public class MainController {

    @Autowired
    ProductService productService;
    @GetMapping("/add")
    public ModelAndView add(@RequestParam Map<String,String> allRequestParams, Model model) {
        ProductDto productDto = new ProductDto();
        productDto.setName(allRequestParams.get("name"));
        productDto.setPrice(Integer.parseInt(allRequestParams.get("price")));
        productDto.setProductCategory(ProductCategory.valueOf(allRequestParams.get("productCategory")));
        productDto.setWeight(Integer.parseInt(allRequestParams.get("weight")));
        productDto.setVolume(Integer.parseInt(allRequestParams.get("volume")));
        productDto.setQuantityInStock(Integer.parseInt(allRequestParams.get("quantityInStock")));
        Product product = productService.add(productDto);
        model.addAttribute("id", product.getProductId());
        return new ModelAndView("product", (Map<String, Integer>) model);
    }

    @GetMapping("/find")
    public String find (@RequestParam(name="id") Integer id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "Product" ;
    }
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {


        return "greeting";
    }
    @GetMapping("/addOdrer")
    public String addOdrer(@RequestParam Map<String,String> allRequestParams, Model model){


        return "congrat";
    }


}