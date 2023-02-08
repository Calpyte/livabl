package com.calpyte.livabl.dao.impl;

import com.calpyte.livabl.dao.UpstreamDAO;
import com.calpyte.livabl.domain.CapitalGoods;
import com.calpyte.livabl.domain.Upstream;
import com.calpyte.livabl.repository.UpstreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UpstreamDAOImpl implements UpstreamDAO{

    @Autowired
    UpstreamRepository upstreamRepository;

    @Override
    public Upstream save(Upstream upstream) { return upstreamRepository.save(upstream); }

    @Override
    public List<Upstream> saveAll(List<Upstream> upstream) {
        return upstreamRepository.saveAll(upstream);
    }

    @Override
    public List<Upstream> findAll() {
        return upstreamRepository.findAll();
    }

    @Override
    public Optional<Upstream> findById(String id) {
        return upstreamRepository.findById(id);
    }
}
