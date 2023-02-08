package com.calpyte.livabl.service;

import com.calpyte.livabl.domain.CapitalGoods;
import com.calpyte.livabl.domain.Upstream;

import java.text.ParseException;
import java.util.List;

public interface UpstreamService {

    Upstream save(Upstream upstream)  throws ParseException;

    List<Upstream> saveAll(List<Upstream> upstream );

    List<Upstream> findAll();

    Upstream findById(String id);
}
