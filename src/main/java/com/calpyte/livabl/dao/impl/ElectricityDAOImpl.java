package com.calpyte.livabl.dao.impl;

import com.calpyte.livabl.dao.ElectricityDAO;
import com.calpyte.livabl.domain.ElectricityConsumption;
import com.calpyte.livabl.repository.ElectricityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ElectricityDAOImpl implements ElectricityDAO {

    @Autowired
    private ElectricityRepository electricityRepository;

    @Override
    public ElectricityConsumption save(ElectricityConsumption electricityConsumption) {
        return electricityRepository.save(electricityConsumption);
    }

    @Override
    public List<ElectricityConsumption> saveAll(List<ElectricityConsumption> electricityConsumptions){
        return electricityRepository.saveAll(electricityConsumptions);
    }

    @Override
    public List<ElectricityConsumption> findAll(){ return electricityRepository.findAll();}

    @Override
    public List<ElectricityConsumption> findByUser(String email) {
        return electricityRepository.findAllByEmail(email);
    }

    @Override
    public Optional<ElectricityConsumption> findById(String id){ return electricityRepository.findById(id);}
}
