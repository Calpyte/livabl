package com.calpyte.livabl.service;

import com.calpyte.livabl.domain.Client;
import com.calpyte.livabl.domain.Combustion;

import java.util.List;

public interface CombustionService {
    Combustion save (Combustion combustion);

    Combustion findById(String id);

    List<Combustion> findAll();

    List<Combustion> saveAll(List<Combustion> combustions);
}
