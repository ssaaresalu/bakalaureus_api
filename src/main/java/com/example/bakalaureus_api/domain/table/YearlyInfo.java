package com.example.bakalaureus_api.domain.table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "yearly_info")
public class YearlyInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="yearly_info_id")
    private Long id;
    @Column(name = "year", nullable = false)
    private String year;
    @Column(name = "nr_of_emplyees")
    private String nrOfEmployees;
    @OneToMany(mappedBy = "yearlyInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StructuralUnit> structuralUnits;
    @OneToMany(mappedBy = "yearlyInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GhgAssessmentScope> ghgAssessmentScopes;
    @ManyToOne
    @JoinColumn(name = "organization_id")
    @JsonIgnore
    private Organization organization;
}
