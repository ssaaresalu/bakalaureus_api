package com.example.bakalaureus_api.domain.table;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table(name = "organization")
public class Organization implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "reporting_period_start", nullable = false)
    private LocalDate reportingPeriodStart;
    @Column(name = "reporting_period_end", nullable = false)
    private LocalDate reportingPeriodEnd;
    private String relativeIndicator;
    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<StructuralUnit> structuralUnit;
    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<GhgAssessmentScope> ghgAssessmentScopes;
}
