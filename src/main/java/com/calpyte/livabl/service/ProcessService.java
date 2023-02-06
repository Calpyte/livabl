package com.calpyte.livabl.service;

import com.calpyte.livabl.domain.ProcessEmissions;
import java.text.ParseException;
import java.util.List;

public interface ProcessService {

    ProcessEmissions save (ProcessEmissions processEmissions) throws ParseException;

    ProcessEmissions findById(String id);

    List<ProcessEmissions> findAll();

    List<ProcessEmissions> saveAll(List<ProcessEmissions> processEmissions);
}
