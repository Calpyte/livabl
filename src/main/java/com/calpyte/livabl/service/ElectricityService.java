package com.calpyte.livabl.service;

import com.calpyte.livabl.domain.ElectricityConsumption;
import com.calpyte.livabl.domain.StationaryCombustion;

import java.text.ParseException;
import java.util.List;

public interface ElectricityService {

    ElectricityConsumption save (ElectricityConsumption electricityConsumption) throws ParseException;

//    List<ElectricityConsumption> saveAll(List<ElectricityConsumption> electricityConsumptions);

    List<ElectricityConsumption> findAllByEmail(String email);

    ElectricityConsumption findById(String id);

    List<ElectricityConsumption> findAll();
}
