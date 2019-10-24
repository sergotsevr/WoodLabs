package com.woodlabs.entities.repositories;

import com.woodlabs.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
