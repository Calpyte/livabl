package com.calpyte.livabl.service;

import com.calpyte.livabl.configuration.CustomException;
import com.calpyte.livabl.domain.CatalogueType;

import java.util.List;

public interface CatalogueTypeService {

    CatalogueType save (CatalogueType type) throws CustomException;

    CatalogueType findById(String id);

    List<CatalogueType> findAll();

    List<CatalogueType> saveAll(List<CatalogueType> types);
}
