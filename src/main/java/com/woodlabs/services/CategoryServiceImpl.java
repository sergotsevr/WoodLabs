package com.woodlabs.services;

import com.woodlabs.dto.ProductCategoryDto;
import com.woodlabs.entities.ProductCategory;
import com.woodlabs.repositories.ProductCategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Transactional
@Component
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    public ProductCategoryDto add(ProductCategoryDto productCategoryDto) {
        ProductCategory productCategory = modelMapper.map(productCategoryDto, ProductCategory.class);
        ProductCategory saved = productCategoryRepository.save(productCategory);
        ProductCategoryDto dto = modelMapper.map(saved, ProductCategoryDto.class);
        return dto;
    }

    @Override
    public void delete(ProductCategoryDto productCategoryDto) {
        ProductCategory productCategory;
        try {
            productCategory = convertToEntity(productCategoryDto);
            productCategoryRepository.delete(productCategory);
            return;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        log.warn("error deleting ProductCategory {}", productCategoryDto);
    }

    @Override
    public ProductCategoryDto update(ProductCategoryDto productCategoryDto) {
        ProductCategory productCategory = modelMapper.map(productCategoryDto, ProductCategory.class);
        ProductCategory saved = productCategoryRepository.save(productCategory);
        ProductCategoryDto dto = modelMapper.map(saved, ProductCategoryDto.class);
        return dto;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductCategoryDto> findAll() {
        try {
            List<ProductCategory> found = productCategoryRepository.findAll();
            List<ProductCategoryDto> dto = new LinkedList<>();
            for (ProductCategory ProductCategory : found) {
                dto.add(modelMapper.map(found, ProductCategoryDto.class));
            }
            return dto;
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.warn("error finding all productCategory");
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public ProductCategoryDto findById(Integer id) {
        try {
            Optional<ProductCategory> productCategory = productCategoryRepository.findById(id);
            if (productCategory.isPresent()) {
                ProductCategory productCategory1 = productCategory.get();
                ProductCategoryDto dto = modelMapper.map(productCategory1, ProductCategoryDto.class);
                return dto;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.warn("error searching productCategory with id = {}", id);
        return null;
    }

    private ProductCategory convertToEntity(ProductCategoryDto productCategoryDto) throws ParseException {
        ProductCategory productCategory = modelMapper.map(productCategoryDto, ProductCategory.class);
        return productCategory;
    }
}
