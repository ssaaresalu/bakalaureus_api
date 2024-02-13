package com.example.bakalaureus_api.service;

import com.example.bakalaureus_api.domain.ListDTO;
import com.example.bakalaureus_api.domain.ListValueItem;
import com.example.bakalaureus_api.domain.table.EmissionFactorList;
import com.example.bakalaureus_api.exception.EmissionFactorListNotFoundException;
import com.example.bakalaureus_api.repo.EmissionFactorListRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EmissionFactorService {
    private final EmissionFactorListRepo emissionFactorListRepo;

    public EmissionFactorService(EmissionFactorListRepo emissionFactorListRepo) {
        this.emissionFactorListRepo = emissionFactorListRepo;
    }

    public List<EmissionFactorList> findAllEmissionFactorLists() {
        return emissionFactorListRepo.findAll();
    }

    public EmissionFactorList findEmissionFactorListByListName(String listName) {
        return emissionFactorListRepo.findByListName(listName).
                orElseThrow(() -> new EmissionFactorListNotFoundException("List named " + listName + " wasn't found"));
    }

    public List<ListDTO> getListsWrapper(String listName) {
        List<EmissionFactorList> factorLists = (listName == null || listName.isBlank()) ?
                findAllEmissionFactorLists() :
                Collections.singletonList(findEmissionFactorListByListName(listName));

        return factorLists.stream().map(list -> {
            ListDTO dto = new ListDTO();
            dto.setListName(list.getListName());
            List<ListValueItem> items = list.getEmissionFactors().stream()
                    .map(ef -> new ListValueItem(ef.getEmissionType(), ef.getFactor()))
                    .collect(Collectors.toList());
            dto.setEmissionFactors(items);
            return dto;
        }).collect(Collectors.toList());
    }
}
