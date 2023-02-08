package com.calpyte.livabl.service;

import com.calpyte.livabl.domain.CapitalGoods;
import com.calpyte.livabl.domain.Franchise;

import java.text.ParseException;
import java.util.List;

public interface FranchiseService {

    Franchise save(Franchise franchise)  throws ParseException;

    List<Franchise> saveAll(List<Franchise> franchise );

    List<Franchise> findAll();

    Franchise findById(String id);
}
