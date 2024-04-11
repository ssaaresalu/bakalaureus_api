package com.example.bakalaureus_api.domain.enums;

import lombok.Getter;

@Getter
public enum ValidList {
    ENERGY("energy"),
    VEHICLE_FULES_1("vehicleFuels1"),
    VEHICLE_FULES_2("vehicleFuels2"),
    VEHICLE_FULES_3("vehicleFuels3"),
    DISPERSED_EMISSIONS("dispersedEmissions"),
    BOUGHT_ELECTRICAL_ENERGY("boughtElectricalEnergy"),
    BOUGHT_HEAT_ENERGY("boughtHeatEnergy"),
    VANS("vans"),
    RIGID_TRUCK_MEAN("rigidTruckMean"),
    RIGID_TRUCK_TONS_FULL("rigidTruckTonsFull"),
    RIGID_TRUCK_TONS_HALF("rigidTruckTonsHalf"),
    ARTICULATED_TRUCK_MEAN("articulatedTruckMean"),
    ARTICULATED_TRUCK_FULL("articulatedTruckFull"),
    ARTICULATED_TRUCK_HALF("articulatedTruckHalf"),
    ARTICULATED_RIGID_MEAN("articulatedRigidMean"),
    ARTICULATED_RIGID_FULL("articulatedRigidFull"),
    ARTICULATED_RIGID_HALF("articulatedRigidHalf"),
    TRANSPORT_BUS("transportBus"),
    TRAINS("trains"),
    PLANES("planes"),
    SHIPS("ships"),
    BUSINESS_TRIPS_SMALL("businessTripsSmall"),
    BUSINESS_TRIPS_BIG("businessTripsBig"),
    WORK_HOME_SMALL_VEHICLE("workHomeSmallVehicle"),
    WORK_HOME_BIG_VEHICLE("workHomeBigVehicle"),
    WASTE("waste"),
    CAPACITY("capacity");

    private final String listName;

    ValidList(String listName) {
        this.listName = listName;
    }
}
