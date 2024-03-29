package com.example.bakalaureus_api.domain.table;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "ghg_assessment_scope")
public class GhgAssessmentScope {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long unitNumber;
    private String influenceArea;
    private String category;
    @ManyToOne
    @JoinColumn(name = "yearly_info_id")
    private YearlyInfo yearlyInfo;
}
