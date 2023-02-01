package com.calpyte.livabl.dao.impl;

import com.calpyte.livabl.dao.CatalogueDAO;
import com.calpyte.livabl.domain.Catalogue;
import com.calpyte.livabl.repository.CatalogueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CatalogueDAOImpl implements CatalogueDAO {

    @Autowired
    private CatalogueRepository catalogueRepository;

    @Override
    public Catalogue save(Catalogue catalogue) {
        return catalogueRepository.save(catalogue);
    }

    @Override
    public Optional<Catalogue> findById(String id) {
        return catalogueRepository.findById(id);
    }

    @Override
    public List<Catalogue> findAll() {
        return catalogueRepository.findAll();
    }

    @Override
    public List<Catalogue> saveAll(List<Catalogue> catalogues) {
        return catalogueRepository.saveAll(catalogues);
    }

    @Override
    public List<Catalogue> findByType(String type) {
        return catalogueRepository.findByType(type);
    }

    @Override
    public List<Catalogue> findByCatalogueType(String id) {
        return catalogueRepository.findByCatalogueTypeId(id);
    }
}
