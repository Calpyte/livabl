package com.calpyte.livabl.service.impl;

import com.calpyte.livabl.dao.FugitiveDAO;
import com.calpyte.livabl.dao.MobileDAO;
import com.calpyte.livabl.domain.FugitiveEmission;
import com.calpyte.livabl.domain.MobileCombustion;
import com.calpyte.livabl.service.FugitiveService;
import com.calpyte.livabl.util.DateUtil;
import com.calpyte.livabl.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FugitiveServiceImpl implements FugitiveService {

    @Autowired
    private FugitiveDAO fugitiveDAO;


    @Override
    public FugitiveEmission save(FugitiveEmission emission) throws ParseException {
        emission.setFugitiveDate(
                emission.getFugitiveDateStr()!=null&&!emission.getFugitiveDateStr().isEmpty() ?
                        DateUtil.StringToDate(emission.getFugitiveDateStr()) : null
        );
        Mapper.setAuditable(toDate(emission));
        return fugitiveDAO.save(emission);
    }

    private FugitiveEmission toDate(FugitiveEmission emission) {
        try{
            emission.setFugitiveDate(
                    emission.getFugitiveDateStr()!=null&&!emission.getFugitiveDateStr().isEmpty() ?
                            DateUtil.StringToDate(emission.getFugitiveDateStr()) : null
            );
        }catch (Exception e){ System.out.println(e);}
        return emission;
    }


    @Override
    public FugitiveEmission findById(String id) {
        return fugitiveDAO.findById(id).orElse(null);
    }

    @Override
    public List<FugitiveEmission> findAll() {return fugitiveDAO.findAll();}

    @Override
    public List<FugitiveEmission> saveAll(List<FugitiveEmission> fugitiveEmissions) {
        return fugitiveDAO.saveAll(fugitiveEmissions.stream().map(fugitive ->{
            Mapper.setAuditable(toDate(fugitive));
            return fugitive;
        }).collect(Collectors.toList()));
    }
}
