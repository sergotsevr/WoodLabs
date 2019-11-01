package com.woodlabs.repositories;

import com.woodlabs.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    public ProductCategory findByName(String name);
}
