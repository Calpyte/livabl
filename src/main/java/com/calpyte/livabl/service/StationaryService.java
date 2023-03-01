package com.calpyte.livabl.service;

import com.calpyte.livabl.domain.StationaryCombustion;

import java.text.ParseException;
import java.util.List;

public interface StationaryService {
    StationaryCombustion save (StationaryCombustion stationaryCombustions) throws ParseException;

    StationaryCombustion findById(String id);

    List<StationaryCombustion> findAll();

    List<StationaryCombustion> findAllByEmail(String email);

    List<StationaryCombustion> saveAll(List<StationaryCombustion> stationaryCombustions);
}
