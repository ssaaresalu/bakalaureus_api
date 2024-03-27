package com.example.bakalaureus_api.domain.table;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "yearly_info")
public class YearlyInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "year", nullable = false)
    private String year;
    @OneToMany(mappedBy = "yearlyInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RelativeIndicator> relativeIndicator;
    @OneToMany(mappedBy = "yearlyInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<StructuralUnit> structuralUnits;
    @OneToMany(mappedBy = "yearlyInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<GhgAssessmentScope> ghgAssessmentScopes;
    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;
}
