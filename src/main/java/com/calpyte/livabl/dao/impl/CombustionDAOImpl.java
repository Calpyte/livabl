package com.calpyte.livabl.dao.impl;

import com.calpyte.livabl.dao.CombustionDAO;
import com.calpyte.livabl.domain.CatalogueType;
import com.calpyte.livabl.domain.Combustion;
import com.calpyte.livabl.repository.CombustionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CombustionDAOImpl implements CombustionDAO {

    @Autowired CombustionRepository combustionRepository;

    @Override
    public Combustion save(Combustion combustion) {
        return combustionRepository.save(combustion);
    }

    @Override
    public Optional<Combustion> findById(String id) {
        return combustionRepository.findById(id);
    }

    @Override
    public List<Combustion> findAll() {
        return combustionRepository.findAll();
    }

    @Override
    public List<Combustion> saveAll(List<Combustion> combustions) {
        return combustionRepository.saveAll(combustions);
    }
}
