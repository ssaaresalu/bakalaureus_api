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
    List<ListValueItem> vans;
    List<ListValueItem> rigidTruckMean;
    List<ListValueItem> rigidTruckTonsFull;
    List<ListValueItem> rigidTruckTonsHalf;
    List<ListValueItem> articulatedTruckMean;
    List<ListValueItem> articulatedTruckFull;
    List<ListValueItem> articulatedTruckHalf;
    List<ListValueItem> articulatedRigidMean;
    List<ListValueItem> articulatedRigidFull;
    List<ListValueItem> articulatedRigidHalf;
    List<ListValueItem> transportBus;
    List<ListValueItem> trains;
    List<ListValueItem> planes;
    List<ListValueItem> ships;
    List<ListValueItem> businessTripsSmall;
    List<ListValueItem> businessTripsBig;
    List<ListValueItem> workHomeSmallVehicle;
    List<ListValueItem> workHomeBigVehicle;
    List<ListValueItem> waste;
    List<ListValueItem> capacity;
}
