package com.calpyte.livabl.dao;

import com.calpyte.livabl.domain.ElectricityConsumption;

import java.util.List;
import java.util.Optional;

public interface ElectricityDAO {

    ElectricityConsumption save(ElectricityConsumption electricityConsumption);

//    List<ElectricityConsumption> saveAll(List<ElectricityConsumption> electricityConsumptions);

    List<ElectricityConsumption> findAll();

    Optional<ElectricityConsumption> findById(String id);
}
