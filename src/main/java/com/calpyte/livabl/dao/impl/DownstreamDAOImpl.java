package com.calpyte.livabl.dao.impl;

import com.calpyte.livabl.dao.DownstreamDAO;
import com.calpyte.livabl.domain.Downstream;
import com.calpyte.livabl.domain.Franchise;
import com.calpyte.livabl.repository.DownStreamRepository;
import com.calpyte.livabl.repository.FranchiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DownstreamDAOImpl implements DownstreamDAO {

    @Autowired
    DownStreamRepository downStreamRepository;

    @Override
    public Downstream save(Downstream downstream) { return downStreamRepository.save(downstream); }

    @Override
    public List<Downstream> saveAll(List<Downstream> downstream) {
        return downStreamRepository.saveAll(downstream);
    }

    @Override
    public List<Downstream> findAll() {
        return downStreamRepository.findAll();
    }

    @Override
    public Optional<Downstream> findById(String id) {
        return downStreamRepository.findById(id);
    }
}
