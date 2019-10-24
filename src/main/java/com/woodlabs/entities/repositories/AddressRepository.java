package com.woodlabs.entities.repositories;

import com.woodlabs.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> {
}
