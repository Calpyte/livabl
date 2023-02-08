package com.calpyte.livabl.service.impl;

import com.calpyte.livabl.dao.CapitalGoodsDAO;
import com.calpyte.livabl.dao.DownstreamDAO;
import com.calpyte.livabl.domain.CapitalGoods;
import com.calpyte.livabl.domain.Downstream;
import com.calpyte.livabl.service.DownstreamService;
import com.calpyte.livabl.util.DateUtil;
import com.calpyte.livabl.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DownstreamServiceImpl implements DownstreamService{

    @Autowired
    private DownstreamDAO downstreamDAO;

    @Override
    public Downstream save(Downstream downstream) throws ParseException {
        downstream.setDate(
                downstream.getDateStr()!=null&&!downstream.getDateStr().isEmpty() ?
                        DateUtil.StringToDate(downstream.getDateStr()) : null
        );
        Mapper.setAuditable(toDate(downstream));
        return downstreamDAO.save(downstream);
    }

    private Downstream toDate(Downstream downstream) {
        try{
            downstream.setDate(
                    downstream.getDateStr()!=null&&!downstream.getDateStr().isEmpty() ?
                            DateUtil.StringToDate(downstream.getDateStr()) : null
            );
        }catch (Exception e){ System.out.println(e);}
        return downstream;
    }


    @Override
    public Downstream findById(String id) {
        return downstreamDAO.findById(id).orElse(null);
    }

    @Override
    public List<Downstream> findAll() {return downstreamDAO.findAll();}

    @Override
    public List<Downstream> saveAll(List<Downstream> downstream) {
        return downstreamDAO.saveAll(downstream.stream().map(mobile ->{
            Mapper.setAuditable(toDate(mobile));
            return mobile;
        }).collect(Collectors.toList()));
    }
}
