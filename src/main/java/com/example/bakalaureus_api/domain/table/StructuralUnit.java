package com.example.bakalaureus_api.domain.table;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JoinColumn(name = "yearly_info_id")
    @JsonIgnore
    private YearlyInfo yearlyInfo;
}
