package com.woodlabs.entities.repositories;

import com.woodlabs.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
