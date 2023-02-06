package com.calpyte.livabl.dao.impl;

import com.calpyte.livabl.dao.StationaryDAO;
import com.calpyte.livabl.domain.StationaryCombustion;
import com.calpyte.livabl.repository.StationaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StationaryDAOImpl implements StationaryDAO {

    @Autowired
    private StationaryRepository repository;

    @Override
    public StationaryCombustion save(StationaryCombustion stationaryCombustion) {
        return repository.save(stationaryCombustion);
    }

    @Override
    public Optional<StationaryCombustion> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<StationaryCombustion> findAll() {
        return repository.findAll();
    }

    @Override
    public List<StationaryCombustion> saveAll(List<StationaryCombustion> stationaryCombustions) {
        return repository.saveAll(stationaryCombustions);
    }

}
