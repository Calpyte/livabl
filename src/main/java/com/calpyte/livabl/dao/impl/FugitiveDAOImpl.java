package com.calpyte.livabl.dao.impl;

import com.calpyte.livabl.dao.FugitiveDAO;
import com.calpyte.livabl.domain.FugitiveEmission;
import com.calpyte.livabl.repository.FugitiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FugitiveDAOImpl implements FugitiveDAO {

    @Autowired
    private FugitiveRepository fugitiveRepository;

    @Override
    public FugitiveEmission save(FugitiveEmission fugitiveEmission) {
        return fugitiveRepository.save(fugitiveEmission);
    }

    @Override
    public Optional<FugitiveEmission> findById(String id) {
        return fugitiveRepository.findById(id);
    }

    @Override
    public List<FugitiveEmission> findAll() {
        return fugitiveRepository.findAll();
    }

    @Override
    public List<FugitiveEmission> saveAll(List<FugitiveEmission> fugitiveEmissions) {
        return fugitiveRepository.saveAll(fugitiveEmissions);
    }
}
