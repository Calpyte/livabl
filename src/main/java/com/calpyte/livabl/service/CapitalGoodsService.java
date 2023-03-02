package com.calpyte.livabl.service;

import com.calpyte.livabl.domain.CapitalGoods;
import com.calpyte.livabl.domain.StationaryCombustion;

import java.text.ParseException;
import java.util.List;

public interface CapitalGoodsService {

    CapitalGoods save(CapitalGoods capitalGoods)  throws ParseException;

    List<CapitalGoods> saveAll(List<CapitalGoods> capitalGoods );

    List<CapitalGoods> findAll();

    List<CapitalGoods> findAllByEmail(String email);

    CapitalGoods findById(String id);
}
