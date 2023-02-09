package com.calpyte.livabl.dao.impl;

import com.calpyte.livabl.dao.ProcessDAO;
import com.calpyte.livabl.domain.ProcessEmissions;
import com.calpyte.livabl.repository.ProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProcessDAOImpl implements ProcessDAO {

    @Autowired
    private ProcessRepository processRepository;

    @Override
    public ProcessEmissions save(ProcessEmissions processEmissions) {
        return processRepository.save(processEmissions);
    }

    @Override
    public Optional<ProcessEmissions> findById(String id) {
        return processRepository.findById(id);
    }

    @Override
    public List<ProcessEmissions> findAll() {
        return processRepository.findAll();
    }

    @Override
    public List<ProcessEmissions> saveAll(List<ProcessEmissions> processEmissions) {
        return processRepository.saveAll(processEmissions);
    }
}
