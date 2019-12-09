package com.woodlabs.controllers;

import com.woodlabs.dto.ClientDto;
import com.woodlabs.dto.ProductDto;
import com.woodlabs.entities.Product;
import com.woodlabs.services.interfaces.ProductCategoryService;
import com.woodlabs.services.interfaces.ProductService;
import com.woodlabs.utils.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/admin/product")
@Slf4j
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    ProductCategoryService productCategoryService;
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product", new ProductDto());

        model.addAttribute("categories", productCategoryService.findAll());
        return "product/productCreate";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("product") ProductDto updatedDto, BindingResult result, @RequestParam Map<String, String> allRequestParams, HttpServletRequest request, Model model) {
       // updatedDto.setProductCategory(null);
        if (result.hasErrors()) {
            model.addAttribute("product", updatedDto);
            log.warn(result.getAllErrors().toString());
            model.addAttribute(result);
            return "product/productCreate";
        }
        if (Util.isNumeric(allRequestParams.get("productId"))) {
            ProductDto productDto = productService.findById(Integer.parseInt(allRequestParams.get("productId")));
            if (productDto != null) {
                log.warn("product with id = {} already exists", allRequestParams.get("productId"));
                return "product/productMain";
            }
        }
        productService.add(updatedDto);
        model.addAttribute("product", updatedDto);
        return "redirect:";
    }

    @GetMapping("")
    public ModelAndView main(Model model){
        List<ProductDto> productList = productService.findAll();
        model.addAttribute("products", productList);
        return new ModelAndView("product/productMain", (Map<String, Product>) model);
    }

    @GetMapping("/find")
    public String find(@RequestParam(name = "id") Integer id, Model model) {
        try {
            model.addAttribute("product", productService.findById(id));
            return "Product";
        }
        catch (Exception e){
            return "main";
        }
    }


    @GetMapping("/delete")
    public String delete(@RequestParam Integer id, Model model) {
        try {
            ProductDto productDto = new ProductDto();
            productDto.setProductId(id);
            productService.delete(productDto);
            return "redirect:";
        }
        catch (Exception e){
            return "redirect:";
        }
    }
    @GetMapping("/productUpdate")
    public String updateView(@RequestParam Integer id, Model model) {
        ProductDto productDto = productService.findById(id);
        model.addAttribute("product", productDto);
        model.addAttribute("categories", productCategoryService.findAll());
        return "product/productUpdate";
    }
    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("product") ProductDto updatedDto, BindingResult result, @RequestParam Map<String, String> allRequestParams, HttpServletRequest request, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("product", updatedDto);
            log.warn(result.getAllErrors().toString());
            model.addAttribute(result);
            return "product/productCreate";
        }
        productService.update(updatedDto);
        model.addAttribute("product", updatedDto);
        return "redirect:";
    }
}