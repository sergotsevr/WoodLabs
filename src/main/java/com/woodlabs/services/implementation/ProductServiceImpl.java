package com.woodlabs.services.implementation;

import com.woodlabs.dto.ProductDto;
import com.woodlabs.entities.Product;
import com.woodlabs.entities.ProductCategory;
import com.woodlabs.repositories.ProductCategoryRepository;
import com.woodlabs.repositories.ProductRepository;
import com.woodlabs.services.interfaces.ProductService;
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

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public Product add(ProductDto productDto) {
        Product product = Mapper.toProduct(productDto);
        if (productDto.getCategoryId() != null) {
            ProductCategory productCategory = productCategoryRepository.findById(productDto.getCategoryId()).get();
            product.setProductCategory(productCategory);
        }
        Product product1 = productRepository.save(product);
        return product1;
    }

    @Override
    public void delete(ProductDto productDto) {
        Product product = Mapper.toProduct(productDto);
        productRepository.deleteById(product.getProductId());
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
            Optional<ProductCategory> productCategory = Optional.ofNullable(productCategoryRepository.getCategory(product.get().getProductId()));
            if (productCategory.isPresent()){
                product.get().setProductCategory(productCategory.get());
            }
            return Mapper.toProductDto(product.get());
        }
        log.warn("No product with id = " + id);
        return null;

    }
}
