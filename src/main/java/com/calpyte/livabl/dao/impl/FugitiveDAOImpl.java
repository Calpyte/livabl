package com.calpyte.livabl.dao.impl;

import com.calpyte.livabl.dao.FugitiveDAO;
import com.calpyte.livabl.domain.FugitiveEmission;
import com.calpyte.livabl.domain.FugitiveGases;
import com.calpyte.livabl.repository.FugitiveGasesRepository;
import com.calpyte.livabl.repository.FugitiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FugitiveDAOImpl implements FugitiveDAO {

    @Autowired
    private FugitiveRepository fugitiveRepository;

    @Autowired
    private FugitiveGasesRepository fugitiveGasesRepository;

    @Override
    public FugitiveEmission save(FugitiveEmission fugitiveEmission) {
        return fugitiveRepository.save(fugitiveEmission);
    }

    @Override
    public Optional<FugitiveEmission> findById(String id) {
        return fugitiveRepository.findById(id);
    }

    @Override
    public FugitiveGases saveGases(FugitiveGases gases) {
        return fugitiveGasesRepository.save(gases);
    }

    @Override
    public List<FugitiveEmission> findByUser(String email) {
        return fugitiveRepository.findAllByEmail(email);
    }

    @Override
    public List<FugitiveGases> findByGases(String email) {
        return fugitiveGasesRepository.findAllByEmail(email);
    }

    @Override
    public List<FugitiveGases> findAllGases() {
        return fugitiveGasesRepository.findAll();
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
