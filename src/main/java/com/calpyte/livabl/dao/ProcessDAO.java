package com.calpyte.livabl.dao;

import com.calpyte.livabl.domain.ProcessEmissions;
import com.calpyte.livabl.domain.StationaryCombustion;

import java.util.List;
import java.util.Optional;

public interface ProcessDAO {

    ProcessEmissions save(ProcessEmissions processEmissions);

    List<ProcessEmissions> saveAll(List<ProcessEmissions> processEmissions);

    List<ProcessEmissions> findAll();

    List<ProcessEmissions> findByUser(String email);

    Optional<ProcessEmissions> findById(String id);
}
