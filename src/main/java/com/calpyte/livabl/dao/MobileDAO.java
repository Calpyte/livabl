package com.calpyte.livabl.dao;

import com.calpyte.livabl.domain.MobileCombustion;
import com.calpyte.livabl.domain.StationaryCombustion;

import java.util.List;
import java.util.Optional;

public interface MobileDAO {

    MobileCombustion save(MobileCombustion mobileCombustion);

    Optional<MobileCombustion> findById(String id);

    List<MobileCombustion> findAll();

    List<MobileCombustion> findByUser(String email);

    List<MobileCombustion> saveAll(List<MobileCombustion> mobileCombustions);
}
