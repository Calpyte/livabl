package com.calpyte.livabl.service;

import com.calpyte.livabl.domain.FugitiveEmission;
import java.text.ParseException;
import java.util.List;

public interface FugitiveService {
    FugitiveEmission save (FugitiveEmission fugitiveEmissions) throws ParseException;

    FugitiveEmission findById(String id);

    List<FugitiveEmission> findAll();

    List<FugitiveEmission> saveAll(List<FugitiveEmission> fugitiveEmissions);
}
