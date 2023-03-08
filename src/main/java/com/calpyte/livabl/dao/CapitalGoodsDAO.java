package com.calpyte.livabl.dao;

import com.calpyte.livabl.domain.CapitalGoods;
import com.calpyte.livabl.domain.StationaryCombustion;

import java.util.List;
import java.util.Optional;

public interface CapitalGoodsDAO {

    CapitalGoods save(CapitalGoods capitalGoods);

    List<CapitalGoods> saveAll(List<CapitalGoods> capitalGoods);

    List<CapitalGoods> findAll();

    List<CapitalGoods> findByUser(String email);

    Optional<CapitalGoods> findById(String id);
}
