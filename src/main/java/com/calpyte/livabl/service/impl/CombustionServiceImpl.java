package com.calpyte.livabl.service.impl;

import com.calpyte.livabl.dao.CombustionDAO;
import com.calpyte.livabl.domain.Combustion;
import com.calpyte.livabl.service.CombustionService;
import com.calpyte.livabl.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CombustionServiceImpl implements CombustionService {
    @Autowired
    private CombustionDAO combustionDAO;

    @Override
    public Combustion save(Combustion combustion) {
        Mapper.setAuditable(combustion);
        return combustionDAO.save(combustion);
    }

    @Override
    public Combustion findById(String id) {
        return combustionDAO.findById(id).orElse(null);
    }

    @Override
    public List<Combustion> findAll() {
        return combustionDAO.findAll();
    }

    @Override
    public List<Combustion> saveAll(List<Combustion> combustions) {
        return combustionDAO.saveAll(combustions.stream().map(combustion -> {Mapper.setAuditable(combustion); return combustion;}).collect(Collectors.toList()));
    }
}
