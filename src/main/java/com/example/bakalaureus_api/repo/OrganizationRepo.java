package com.example.bakalaureus_api.repo;

import com.example.bakalaureus_api.domain.table.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrganizationRepo extends JpaRepository<Organization, Long> {
    void deleteOrganizationById(Long id);

    Optional<Organization> findOrganizationById(Long id);
}
