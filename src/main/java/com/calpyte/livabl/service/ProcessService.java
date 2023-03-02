package com.calpyte.livabl.service;

import com.calpyte.livabl.domain.ProcessEmissions;
import com.calpyte.livabl.domain.StationaryCombustion;

import java.text.ParseException;
import java.util.List;

public interface ProcessService {

    ProcessEmissions save (ProcessEmissions processEmissions) throws ParseException;

    ProcessEmissions findById(String id);

    List<ProcessEmissions> findAll();

    List<ProcessEmissions> findAllByEmail(String email);

    List<ProcessEmissions> saveAll(List<ProcessEmissions> processEmissions);
}
