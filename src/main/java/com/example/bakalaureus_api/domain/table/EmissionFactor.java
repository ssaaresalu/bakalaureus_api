package com.example.bakalaureus_api.domain.table;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
public class EmissionFactor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String emissionType;
    private Double factor;

    @ManyToOne
    @JoinColumn(name = "emission_factor_list_id")
    private EmissionFactorList emissionFactorList;
}
