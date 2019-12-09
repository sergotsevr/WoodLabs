package com.woodlabs.repositories;

import com.woodlabs.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

     ProductCategory findByName(String name);
     @Query(value = "SELECT * FROM product_category c WHERE c.product =(:product_id)",
             nativeQuery = true)
     ProductCategory getCategory(@Param("product_id") Integer id);

     void deleteByProductCategoryId(Integer id);
}
