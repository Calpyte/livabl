package com.calpyte.livabl.service;

import com.calpyte.livabl.domain.CapitalGoods;

import java.text.ParseException;
import java.util.List;

public interface CapitalGoodsService {

    CapitalGoods save(CapitalGoods capitalGoods)  throws ParseException;

    List<CapitalGoods> saveAll(List<CapitalGoods> capitalGoods );

    List<CapitalGoods> findAll();

    CapitalGoods findById(String id);
}
