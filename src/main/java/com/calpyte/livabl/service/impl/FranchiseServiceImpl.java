package com.calpyte.livabl.service.impl;

import com.calpyte.livabl.dao.FranchiseDAO;
import com.calpyte.livabl.domain.Franchise;
import com.calpyte.livabl.domain.StationaryCombustion;
import com.calpyte.livabl.service.FranchiseService;
import com.calpyte.livabl.util.DateUtil;
import com.calpyte.livabl.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FranchiseServiceImpl implements FranchiseService {
    @Autowired
    private FranchiseDAO franchiseDAO;

    @Override
    public Franchise save(Franchise franchise) throws ParseException {
//        franchise.setDate(
//                franchise.getDateStr()!=null&&!franchise.getDateStr().isEmpty() ?
//                        DateUtil.StringToDate(franchise.getDateStr()) : null
//        );
        Mapper.setAuditable(franchise);
        return franchiseDAO.save(franchise);
    }

    private Franchise toDate(Franchise franchise) {
        try{
            franchise.setFranchiseDate(
                    franchise.getFranchiseDateStr()!=null&&!franchise.getFranchiseDateStr().isEmpty() ?
                            DateUtil.StringToDate(franchise.getFranchiseDateStr()) : null
            );
        }catch (Exception e){ System.out.println(e);}
        return franchise;
    }


    private Franchise toString(Franchise franchise) {
        try{
            franchise.setFranchiseDateStr(
                    franchise.getFranchiseDate()!=null ?
                            DateUtil.DateToString(franchise.getFranchiseDate()) : null
            );
        }catch (Exception e){ System.out.println(e);}
        return franchise;
    }


    @Override
    public Franchise findById(String id) {
        return franchiseDAO.findById(id).orElse(null);
    }

    @Override
    public List<Franchise> findAll() {
        return franchiseDAO.findAll().stream().map(this::toString).collect(Collectors.toList());}

    @Override
    public List<Franchise> saveAll(List<Franchise> franchise) {
        return franchiseDAO.saveAll(franchise.stream().map(mobile ->{
            Mapper.setAuditable(toDate(mobile));
            return mobile;
        }).collect(Collectors.toList()));
    }
}
