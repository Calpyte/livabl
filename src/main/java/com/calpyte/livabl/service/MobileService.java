package com.calpyte.livabl.service;

import com.calpyte.livabl.domain.MobileCombustion;
import com.calpyte.livabl.domain.StationaryCombustion;

import java.text.ParseException;
import java.util.List;

public interface MobileService {

    MobileCombustion save (MobileCombustion mobileCombustions) throws ParseException;

    MobileCombustion findById(String id);

    List<MobileCombustion> findAll();

    List<MobileCombustion> findAllByEmail(String email);

    List<MobileCombustion> saveAll(List<MobileCombustion> mobileCombustions);
}
