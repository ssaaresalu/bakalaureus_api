package com.example.bakalaureus_api.controller;

import com.example.bakalaureus_api.domain.EmissionLists;
import com.example.bakalaureus_api.domain.ListDTO;
import com.example.bakalaureus_api.service.EmissionFactorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/emissionfactors")
@RequiredArgsConstructor
public class EmissionFactorController {
    private final EmissionFactorService emissionFactorService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ListDTO>> getEmissionFactorLists(
            @RequestParam(value = "listName", required = false) String listName
    ) {
        List<ListDTO> listsWrapper = emissionFactorService.getListsWrapper(listName);
        return ResponseEntity.ok(listsWrapper);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<EmissionLists> getAllEmissionFactorLists() {
        EmissionLists lists = emissionFactorService.getEmissionFactorLists();
        return ResponseEntity.ok(lists);
    }
}
