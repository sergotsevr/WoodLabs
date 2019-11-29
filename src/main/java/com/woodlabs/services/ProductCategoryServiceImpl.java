package com.woodlabs.services;

import com.woodlabs.dto.ProductCategoryDto;
import com.woodlabs.dto.ProductDto;
import com.woodlabs.entities.ProductCategory;
import com.woodlabs.repositories.ProductCategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Component
@Slf4j
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    ProductCategoryRepository productCategoryRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductCategory findByName(String str) {
        return productCategoryRepository.findByName(str);
    }

    @Override
    public ProductCategoryDto create(ProductCategoryDto productCategoryDto) {
        ProductCategory productCategory = modelMapper.map(productCategoryDto, ProductCategory.class);
        ProductCategory saved = productCategoryRepository.save(productCategory);
        ProductCategoryDto savedDto = modelMapper.map(saved, ProductCategoryDto.class);
        return savedDto;
    }

    @Override
    public void delete(ProductCategoryDto productCategoryDto) {

    }

    @Override
    public ProductCategoryDto update(ProductCategoryDto productCategoryDto) {
        return null;
    }

    @Override
    public List<ProductCategoryDto> findAll() {
        return null;
    }

    @Override
    public ProductCategoryDto findById(Integer id) {
        return null;
    }
}
