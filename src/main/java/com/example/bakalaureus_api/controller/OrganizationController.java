package com.example.bakalaureus_api.controller;

import com.example.bakalaureus_api.domain.table.Organization;
import com.example.bakalaureus_api.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organization")
@RequiredArgsConstructor
public class OrganizationController {
    private final OrganizationService organizationService;


    @GetMapping("/all")
    public ResponseEntity<List<Organization>> getOrganizations() {
        List<Organization> organizations = organizationService.findAllOrganizations();
        return new ResponseEntity<>(organizations, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Organization> getOrganizationById(@PathVariable("id") Long id) {
        Organization organization = organizationService.findOrganizationById(id);
        return new ResponseEntity<>(organization, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Organization> addOrganization(@RequestBody Organization organization) {
        Organization newOrganization = organizationService.addOrganization(organization);
        return new ResponseEntity<>(newOrganization, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Organization> updateOrganization(@RequestBody Organization organization) {
        Organization updateOrganization = organizationService.updateOrganization(organization);
        return new ResponseEntity<>(updateOrganization, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOrganization(@PathVariable("id") Long id) {
        organizationService.deleteOrganization(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
