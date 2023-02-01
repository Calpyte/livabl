package com.calpyte.livabl.dao.impl;

import com.calpyte.livabl.dao.CatalogueTypeDAO;
import com.calpyte.livabl.domain.CatalogueType;
import com.calpyte.livabl.repository.CatalogueTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CatalogueTypeDAOImpl implements CatalogueTypeDAO {

    @Autowired
    private CatalogueTypeRepository typeRepository;

    @Override
    public CatalogueType save(CatalogueType type) {
        return typeRepository.save(type);
    }

    @Override
    public Optional<CatalogueType> findById(String id) {
        return typeRepository.findById(id);
    }

    @Override
    public List<CatalogueType> findAll() {
        return typeRepository.findAll();
    }

    @Override
    public List<CatalogueType> saveAll(List<CatalogueType> types) {
        return typeRepository.saveAll(types);
    }
}
