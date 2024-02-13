package com.example.bakalaureus_api.domain.table;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class EmissionFactorList implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String listName;

    @OneToMany(mappedBy = "emissionFactorList", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmissionFactor> emissionFactors = new ArrayList<>();
}