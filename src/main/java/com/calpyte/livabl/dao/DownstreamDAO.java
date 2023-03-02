package com.calpyte.livabl.dao;

import com.calpyte.livabl.domain.Downstream;
import com.calpyte.livabl.domain.StationaryCombustion;

import java.util.List;
import java.util.Optional;

public interface DownstreamDAO {
    Downstream save(Downstream downstream);

    List<Downstream> saveAll(List<Downstream> downstream);

    List<Downstream> findAll();

    List<Downstream> findByUser(String email);

    Optional<Downstream> findById(String id);
}
