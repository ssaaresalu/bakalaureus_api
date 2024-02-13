package com.example.bakalaureus_api.service;

import com.example.bakalaureus_api.domain.table.Organization;
import com.example.bakalaureus_api.exception.OrganizationNotFoundException;
import com.example.bakalaureus_api.repo.OrganizationRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {
    private final OrganizationRepo organizationRepo;

    public OrganizationService(OrganizationRepo organizationRepo) {
        this.organizationRepo = organizationRepo;
    }

    public Organization addOrganization(Organization organization) {
        return organizationRepo.save(organization);
    }

    public List<Organization> findAllOrganizations() {
        return organizationRepo.findAll();
    }

    public Organization findOrganizationById(Long id) {
        return organizationRepo.findOrganizationById(id).
                orElseThrow(() -> new OrganizationNotFoundException("Organization by id " + id + " was not found"));
    }

    public Organization updateOrganization(Organization organization) {
        return organizationRepo.save(organization);
    }

    public void deleteOrganization(Long id) {
        organizationRepo.deleteOrganizationById(id);
    }
}
