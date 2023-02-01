package com.calpyte.livabl.dao;

import com.calpyte.livabl.domain.CatalogueType;
import com.calpyte.livabl.domain.Combustion;

import java.util.List;
import java.util.Optional;

public interface CombustionDAO {
    Combustion save(Combustion combustion);

    Optional<Combustion> findById(String id);

    List<Combustion> findAll();

    List<Combustion> saveAll(List<Combustion> combustions);

}
