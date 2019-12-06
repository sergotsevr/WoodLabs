package com.woodlabs.repositories;

import com.woodlabs.entities.Product;
import com.woodlabs.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    /*@Query(
            value = "SELECT * FROM product_category ORDER BY id",
            countQuery = "SELECT count(*) FROM product_category",
            nativeQuery = true)*/
    @Query(value = "SELECT * FROM product_category c WHERE c.product =(:product_id)",
            nativeQuery = true)
    List<String> getCategory(@Param("product_id") Integer id);
}
