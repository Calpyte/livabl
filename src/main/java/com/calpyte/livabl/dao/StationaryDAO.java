package com.calpyte.livabl.dao;

import com.calpyte.livabl.domain.Combustion;
import com.calpyte.livabl.domain.StationaryCombustion;

import java.util.List;
import java.util.Optional;

public interface StationaryDAO {
    StationaryCombustion save(StationaryCombustion stationaryCombustion);

    Optional<StationaryCombustion> findById(String id);

    List<StationaryCombustion> findAll();

    List<StationaryCombustion> saveAll(List<StationaryCombustion> stationaryCombustions);
}
