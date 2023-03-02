package com.calpyte.livabl.service;

import com.calpyte.livabl.domain.FugitiveEmission;
import com.calpyte.livabl.domain.FugitiveGases;
import com.calpyte.livabl.domain.StationaryCombustion;

import java.text.ParseException;
import java.util.List;

public interface FugitiveService {
    FugitiveEmission save (FugitiveEmission fugitiveEmissions) throws ParseException;

    FugitiveEmission findById(String id);

    List<FugitiveEmission> findAll();

    List<FugitiveEmission> saveAll(List<FugitiveEmission> fugitiveEmissions);

    FugitiveGases saveGases(FugitiveGases gases);

    List<FugitiveEmission> findAllByEmail(String email);

    List<FugitiveGases> findByUsers(String email);

    List<FugitiveGases> findAllGases();
}
