package com.example.bakalaureus_api.domain.table;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "structural_unit")
public class StructuralUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long number;
    private String name;
    private String location;
    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

}
