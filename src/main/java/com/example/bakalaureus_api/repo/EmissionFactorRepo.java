package com.example.bakalaureus_api.repo;

import com.example.bakalaureus_api.domain.table.EmissionFactor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmissionFactorRepo extends JpaRepository<EmissionFactor, Long> {
}
