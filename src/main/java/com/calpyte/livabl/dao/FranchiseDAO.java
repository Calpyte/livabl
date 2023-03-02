package com.calpyte.livabl.dao;

import com.calpyte.livabl.domain.Franchise;
import com.calpyte.livabl.domain.StationaryCombustion;

import java.util.List;
import java.util.Optional;

public interface FranchiseDAO {

    Franchise save(Franchise franchise);

    List<Franchise> saveAll(List<Franchise> franchise);

    List<Franchise> findAll();

    List<Franchise> findByUser(String email);

    Optional<Franchise> findById(String id);
}
