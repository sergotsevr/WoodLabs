package com.woodlabs.repositories;

import com.woodlabs.entities.Product;
import com.woodlabs.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    /*@Query("SELECT name from product_category where product_category.product =(:product_id)")
    List<String> getCategory(@Param("product_id") Integer id);*/
}
