package com.example.bakalaureus_api.domain.table;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
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
    private String reportingPeriodStart;
    @Column(name = "reporting_period_end", nullable = false)
    private String reportingPeriodEnd;
    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<YearlyInfo> yearlyInfo;
}
