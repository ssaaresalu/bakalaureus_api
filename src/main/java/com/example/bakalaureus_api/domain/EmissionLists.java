package com.example.bakalaureus_api.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class EmissionLists {
    List<ListValueItem> energy;
    List<ListValueItem> vehicleFuels1;
    List<ListValueItem> vehicleFuels2;
    List<ListValueItem> vehicleFuels3;
    List<ListValueItem> dispersedEmissions;
    List<ListValueItem> boughtElectricalEnergy;
    List<ListValueItem> boughtHeatEnergy;
}
