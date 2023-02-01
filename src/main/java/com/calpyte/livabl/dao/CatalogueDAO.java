package com.calpyte.livabl.dao;

import com.calpyte.livabl.domain.Catalogue;

import java.util.List;
import java.util.Optional;

public interface CatalogueDAO {

    Catalogue save(Catalogue catalogue);

    Optional<Catalogue> findById(String id);

    List<Catalogue> findAll();

    List<Catalogue> saveAll(List<Catalogue> catalogues);

    List<Catalogue> findByType(String type);

    List<Catalogue> findByCatalogueType(String id);
}
