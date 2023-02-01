package com.calpyte.livabl.dao;

import com.calpyte.livabl.domain.CatalogueType;

import java.util.List;
import java.util.Optional;

public interface CatalogueTypeDAO {

    CatalogueType save(CatalogueType type);

    Optional<CatalogueType> findById(String id);

    List<CatalogueType> findAll();

    List<CatalogueType> saveAll(List<CatalogueType> types);
}
