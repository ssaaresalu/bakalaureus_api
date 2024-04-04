package com.example.bakalaureus_api.service;

import com.example.bakalaureus_api.domain.table.*;
import com.example.bakalaureus_api.exception.OrganizationNotFoundException;
import com.example.bakalaureus_api.repo.OrganizationRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class OrganizationService {
    private final OrganizationRepo organizationRepo;

    public OrganizationService(OrganizationRepo organizationRepo) {
        this.organizationRepo = organizationRepo;
    }

    public Organization addOrganization(Organization organization) {
        List<YearlyInfo> yearlyInfo = organization.getYearlyInfo();
        yearlyInfo.forEach(info -> {
            info.setOrganization(organization);

            Optional.ofNullable(info.getStructuralUnits()).ifPresent(units ->
                    units.forEach(unit -> unit.setYearlyInfo(info))
            );

            Optional.ofNullable(info.getGhgAssessmentScopes()).ifPresent(scopes ->
                    scopes.forEach(assessmentScope -> assessmentScope.setYearlyInfo(info))
            );
        });
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
