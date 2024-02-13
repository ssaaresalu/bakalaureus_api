package com.example.bakalaureus_api.domain.enums;

public enum ValidList {
    ENERGY("energy"),
    VEHICLE_FULES_1("vehicleFuels1"),
    VEHICLE_FULES_2("vehicleFuels2"),
    VEHICLE_FULES_3("vehicleFuels3"),
    DISPERSED_EMISSIONS("dispersedEmissions"),
    BOUGHT_ELECTRICAL_ENERGY("boughtElectricalEnergy"),
    BOUGHT_HEAT_ENERGY("boughtHeatEnergy"),
    ;

    private final String listName;

    ValidList(String listName) {
        this.listName = listName;
    }

    public String getListName() {
        return this.listName;
    }
}
