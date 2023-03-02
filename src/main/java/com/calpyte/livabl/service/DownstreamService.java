package com.calpyte.livabl.service;

import com.calpyte.livabl.domain.Downstream;
import com.calpyte.livabl.domain.StationaryCombustion;

import java.text.ParseException;
import java.util.List;

public interface DownstreamService {

    Downstream save(Downstream downstream)  throws ParseException;

    List<Downstream> saveAll(List<Downstream> downstream );

    List<Downstream> findAll();

    List<Downstream> findAllByEmail(String email);

    Downstream findById(String id);
}
