package com.example.bakalaureus_api.service;

import com.example.bakalaureus_api.domain.EmissionLists;
import com.example.bakalaureus_api.domain.ListDTO;
import com.example.bakalaureus_api.domain.ListValueItem;
import com.example.bakalaureus_api.domain.enums.ValidList;
import com.example.bakalaureus_api.domain.table.EmissionFactorList;
import com.example.bakalaureus_api.exception.EmissionFactorListNotFoundException;
import com.example.bakalaureus_api.repo.EmissionFactorListRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EmissionFactorService {
    private final EmissionFactorListRepo emissionFactorListRepo;

    public EmissionFactorService(EmissionFactorListRepo emissionFactorListRepo) {
        this.emissionFactorListRepo = emissionFactorListRepo;
    }

    public List<EmissionFactorList> findAllEmissionFactorLists() {
        return emissionFactorListRepo.findAll();
    }

    public EmissionFactorList findEmissionFactorListByListName(String listName) {
        return emissionFactorListRepo.findByListName(listName).
                orElseThrow(() -> new EmissionFactorListNotFoundException("List named " + listName + " wasn't found"));
    }

    public List<ListDTO> getListsWrapper(String listName) {
        List<EmissionFactorList> factorLists = (listName == null || listName.isBlank()) ?
                findAllEmissionFactorLists() :
                Collections.singletonList(findEmissionFactorListByListName(listName));

        return factorLists.stream().map(list -> {
            ListDTO dto = new ListDTO();
            dto.setListName(list.getListName());
            List<ListValueItem> items = list.getEmissionFactors().stream()
                    .map(ef -> new ListValueItem(ef.getEmissionType(), ef.getFactor()))
                    .collect(Collectors.toList());
            dto.setEmissionFactors(items);
            return dto;
        }).collect(Collectors.toList());
    }

    public EmissionLists getEmissionFactorLists() {
        EmissionLists response = new EmissionLists();
        List<ListDTO> lists = getListsWrapper("");
        response.setEnergy(getListValuesByEnum(ValidList.ENERGY, lists));
        response.setVehicleFuels1(getListValuesByEnum(ValidList.VEHICLE_FULES_1, lists));
        response.setVehicleFuels2(getListValuesByEnum(ValidList.VEHICLE_FULES_2, lists));
        response.setVehicleFuels3(getListValuesByEnum(ValidList.VEHICLE_FULES_3, lists));
        response.setDispersedEmissions(getListValuesByEnum(ValidList.DISPERSED_EMISSIONS, lists));
        response.setBoughtElectricalEnergy(getListValuesByEnum(ValidList.BOUGHT_ELECTRICAL_ENERGY, lists));
        response.setBoughtHeatEnergy(getListValuesByEnum(ValidList.BOUGHT_HEAT_ENERGY, lists));
        response.setVans(getListValuesByEnum(ValidList.VANS, lists));
        response.setRigidTruckMean(getListValuesByEnum(ValidList.RIGID_TRUCK_MEAN, lists));
        response.setRigidTruckTonsFull(getListValuesByEnum(ValidList.RIGID_TRUCK_TONS_FULL, lists));
        response.setRigidTruckTonsHalf(getListValuesByEnum(ValidList.RIGID_TRUCK_TONS_HALF, lists));
        response.setArticulatedTruckMean(getListValuesByEnum(ValidList.ARTICULATED_TRUCK_MEAN, lists));
        response.setArticulatedTruckFull(getListValuesByEnum(ValidList.ARTICULATED_TRUCK_FULL, lists));
        response.setArticulatedTruckHalf(getListValuesByEnum(ValidList.ARTICULATED_TRUCK_HALF, lists));
        response.setArticulatedRigidMean(getListValuesByEnum(ValidList.ARTICULATED_RIGID_MEAN, lists));
        response.setArticulatedRigidFull(getListValuesByEnum(ValidList.ARTICULATED_RIGID_FULL, lists));
        response.setArticulatedRigidHalf(getListValuesByEnum(ValidList.ARTICULATED_RIGID_HALF, lists));
        response.setTransportBus(getListValuesByEnum(ValidList.TRANSPORT_BUS, lists));
        response.setTrains(getListValuesByEnum(ValidList.TRAINS, lists));
        response.setPlanes(getListValuesByEnum(ValidList.PLANES, lists));
        response.setShips(getListValuesByEnum(ValidList.SHIPS, lists));
        response.setBusinessTripsSmall(getListValuesByEnum(ValidList.BUSINESS_TRIPS_SMALL, lists));
        response.setBusinessTripsBig(getListValuesByEnum(ValidList.BUSINESS_TRIPS_BIG, lists));
        response.setWorkHomeSmallVehicle(getListValuesByEnum(ValidList.WORK_HOME_SMALL_VEHICLE, lists));
        response.setWorkHomeBigVehicle(getListValuesByEnum(ValidList.WORK_HOME_BIG_VEHICLE, lists));
        response.setWaste(getListValuesByEnum(ValidList.WASTE, lists));
        response.setCapacity(getListValuesByEnum(ValidList.CAPACITY, lists));
        return response;
    }

    List<ListValueItem> getListValuesByEnum(ValidList listName, List<ListDTO> lists) {
        List<ListValueItem> foundList = lists.stream().filter(list ->
                list.getListName().equals(listName.getListName()))
                .findFirst().orElse(new ListDTO()).getEmissionFactors();
        return Objects.requireNonNullElseGet(foundList, ArrayList::new);
    }
}
