package com.calpyte.livabl.service;

import com.calpyte.livabl.domain.Combustion;
import com.calpyte.livabl.dto.ExcelDTO;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface CombustionService {
    Combustion save (Combustion combustion) throws ParseException;

    Combustion findById(String id);

    List<Combustion> findAll();

    List<Combustion> saveAll(List<Combustion> combustions);

    ByteArrayInputStream downloadExcel(ExcelDTO exportDTO) throws IOException;

}
