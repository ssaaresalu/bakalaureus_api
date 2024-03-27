package com.example.bakalaureus_api.domain.table;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "relative-indicator")
public class RelativeIndicator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "employee_count", nullable = false)
    private String employeeCount;
    @ManyToOne
    @JoinColumn(name = "yearly_info_id")
    private YearlyInfo yearlyInfo;
}
