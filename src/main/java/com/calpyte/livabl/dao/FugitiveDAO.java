package com.calpyte.livabl.dao;

import com.calpyte.livabl.domain.FugitiveEmission;
import com.calpyte.livabl.domain.FugitiveGases;
import com.calpyte.livabl.domain.StationaryCombustion;

import java.util.List;
import java.util.Optional;

public interface FugitiveDAO {

    FugitiveEmission save(FugitiveEmission fugitiveEmission);

    List<FugitiveEmission> saveAll(List<FugitiveEmission> fugitiveEmissions);

    List<FugitiveEmission> findAll();

    Optional<FugitiveEmission> findById(String id);

    FugitiveGases saveGases(FugitiveGases gases);

    List<FugitiveEmission> findByUser(String email);

    List<FugitiveGases> findByGases(String email);

    List<FugitiveGases> findAllGases();

}
