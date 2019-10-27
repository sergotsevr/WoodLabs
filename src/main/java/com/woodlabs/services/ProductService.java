package com.woodlabs.services;

import com.woodlabs.entities.DTO.ProductDto;
import com.woodlabs.entities.Product;
import com.woodlabs.entities.enums.ProductCategory;
import com.woodlabs.repositories.ProductRepository;
import com.woodlabs.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product add(ProductDto productDto) {
        Product product = Mapper.toProduct(productDto);
        Product product1 = productRepository.save(product);
        return product1;
    }

    public void delete(ProductDto productDto) {
        Product product = Mapper.toProduct(productDto);
        productRepository.delete(product);
    }

    public ProductDto update(ProductDto productDto) {
        Product product = Mapper.toProduct(productDto);
        Product saved = productRepository.save(product);
        ProductDto dto = Mapper.toProductDto(saved);
        return dto;
    }

    public List<ProductDto> findAll() {
        List<Product> listOfProducts = productRepository.findAll();
        List<ProductDto> dtoList = new LinkedList<>();
        for (Product product : listOfProducts) {
            dtoList.add(Mapper.toProductDto(product));
        }
        if (dtoList.isEmpty()) {
            System.out.println("OperationStage list is empty");
        }
        return dtoList;
    }

    public ProductDto findById(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return Mapper.toProductDto(product.get());
        }
        System.out.println("No OperationStage with id= " + id);
        return null;

    }
}
