package com.example.bakalaureus_api.repo;

import com.example.bakalaureus_api.domain.table.EmissionFactorList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmissionFactorListRepo extends JpaRepository<EmissionFactorList, Long> {
    Optional<EmissionFactorList> findByListName(String listName);
}
