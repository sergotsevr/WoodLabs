package com.woodlabs.controllers;

import com.woodlabs.dto.ProductDto;
import com.woodlabs.entities.Product;
import com.woodlabs.services.ProductCategoryService;
import com.woodlabs.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/admin/product")
@Slf4j
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/create")
    public String create(Model model){
        return "product/productCreate";
    }

    @GetMapping("")
    public ModelAndView main(Model model){
        List<ProductDto> productList = productService.findAll();
        model.addAttribute("products", productList);
        return new ModelAndView("product/productMain", (Map<String, Product>) model);
    }

    @PostMapping("/add")
    public ModelAndView add(@RequestParam Map<String, String> allRequestParams, Model model) {
        try {
            ProductDto productDto = new ProductDto();
            productDto.setName(allRequestParams.get("name"));
            String price = allRequestParams.get("price");
            productDto.setPrice(Integer.parseInt(price));
            productDto.setProductCategory(ProductCategoryService.findByName(allRequestParams.get("productCategory")));
            productDto.setWeight(Integer.parseInt(allRequestParams.get("weight")));
            productDto.setVolume(Integer.parseInt(allRequestParams.get("volume")));
            productDto.setQuantityInStock(Integer.parseInt(allRequestParams.get("quantityInStock")));
            Product product = productService.add(productDto);
            model.addAttribute("product", product);
            return new ModelAndView("product", (Map<String, Product>) model);
        } catch (TransactionSystemException e) {
            log.warn("attempt to add product with incorrect field");
        } catch (NumberFormatException e) {
            log.warn("attempt to add product with incorrect digital format field");
        }
        return new ModelAndView("main");
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

    @PostMapping("/update")
    public ModelAndView update(@RequestParam Map<String, String> allRequestParams, Model model) {
        try {
            ProductDto productDto = new ProductDto();
            productDto.setProductId(Integer.parseInt(allRequestParams.get("id")));
            productDto.setName(allRequestParams.get("name"));
            productDto.setPrice(Integer.parseInt(allRequestParams.get("price")));
            productDto.setProductCategory(ProductCategoryService.findByName(allRequestParams.get("productCategory")));
            productDto.setWeight(Integer.parseInt(allRequestParams.get("weight")));
            productDto.setVolume(Integer.parseInt(allRequestParams.get("volume")));
            productDto.setQuantityInStock(Integer.parseInt(allRequestParams.get("quantityInStock")));
            Product product = productService.add(productDto);
            model.addAttribute("product", product);
            return new ModelAndView("product", (Map<String, Product>) model);
        } catch (TransactionSystemException e) {
            log.warn("attempt to update product with incorrect field");
        } catch (NumberFormatException e) {
            log.warn("attempt to update product with incorrect digital format field");
        }
        return new ModelAndView("main");
    }
}