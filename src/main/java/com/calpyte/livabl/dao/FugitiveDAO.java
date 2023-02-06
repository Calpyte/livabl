package com.calpyte.livabl.dao;

import com.calpyte.livabl.domain.FugitiveEmission;

import java.util.List;
import java.util.Optional;

public interface FugitiveDAO {

    FugitiveEmission save(FugitiveEmission fugitiveEmission);

    List<FugitiveEmission> saveAll(List<FugitiveEmission> fugitiveEmissions);

    List<FugitiveEmission> findAll();

    Optional<FugitiveEmission> findById(String id);
}
