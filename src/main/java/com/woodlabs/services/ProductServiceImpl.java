package com.woodlabs.services;

import com.woodlabs.dto.ProductDto;
import com.woodlabs.entities.Product;
import com.woodlabs.repositories.ProductRepository;
import com.woodlabs.utils.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Component
@Transactional
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product add(ProductDto productDto) {
        Product product = Mapper.toProduct(productDto);
        Product product1 = productRepository.save(product);
        return product1;
    }

    @Override
    public void delete(ProductDto productDto) {
        Product product = Mapper.toProduct(productDto);
        productRepository.delete(product);
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        Product product = Mapper.toProduct(productDto);
        Product saved = productRepository.save(product);
        ProductDto dto = Mapper.toProductDto(saved);
        return dto;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDto> findAll() {
        List<Product> listOfProducts = productRepository.findAll();
        List<ProductDto> dtoList = new LinkedList<>();
        for (Product product : listOfProducts) {
            dtoList.add(Mapper.toProductDto(product));
        }
        if (dtoList.isEmpty()) {
            log.warn("Product list is empty");
        }
        return dtoList;
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDto findById(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return Mapper.toProductDto(product.get());
        }
        log.warn("No product with id = " + id);
        return null;

    }
}
