package com.calpyte.livabl.service;

import com.calpyte.livabl.domain.Catalogue;
import com.calpyte.livabl.dto.CatalogueDTO;

import java.util.List;

public interface CatalogueService {

    Catalogue save (CatalogueDTO catalogue);

    Catalogue findById(String id);

    List<Catalogue> findAll();

    List<Catalogue> saveAll(List<CatalogueDTO> catalogue);

    List<Catalogue> findByType(String type);

    List<Catalogue> findByCatalogueTypeId(String id);

}
