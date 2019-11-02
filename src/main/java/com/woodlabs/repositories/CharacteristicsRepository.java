package com.woodlabs.repositories;

import com.woodlabs.entities.Characteristics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacteristicsRepository extends JpaRepository<Characteristics, Integer> {
}
