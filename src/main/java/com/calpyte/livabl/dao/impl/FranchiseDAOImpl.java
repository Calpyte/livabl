package com.calpyte.livabl.dao.impl;

import com.calpyte.livabl.dao.FranchiseDAO;
import com.calpyte.livabl.domain.Franchise;
import com.calpyte.livabl.domain.Upstream;
import com.calpyte.livabl.repository.FranchiseRepository;
import com.calpyte.livabl.repository.UpstreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FranchiseDAOImpl implements FranchiseDAO {

    @Autowired
    FranchiseRepository franchiseRepository;

    @Override
    public Franchise save(Franchise franchise) { return franchiseRepository.save(franchise); }

    @Override
    public List<Franchise> saveAll(List<Franchise> franchise) {
        return franchiseRepository.saveAll(franchise);
    }

    @Override
    public List<Franchise> findAll() {
        return franchiseRepository.findAll();
    }

    @Override
    public List<Franchise> findByUser(String email) {
        return franchiseRepository.findAllByEmail(email);
    }

    @Override
    public Optional<Franchise> findById(String id) {
        return franchiseRepository.findById(id);
    }
}
