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
//        downstream.setDownstreamDate(
//                downstream.getDownstreamDateStr()!=null&&!downstream.getDownstreamDateStr().isEmpty() ?
//                        DateUtil.StringToDate(downstream.getDownstreamDateStr()) : null
//        );
        Mapper.setAuditable(downstream);
        return downstreamDAO.save(downstream);
    }

    private Downstream toDate(Downstream downstream) {
        try{
            downstream.setDownstreamDate(
                    downstream.getDownstreamDateStr()!=null&&!downstream.getDownstreamDateStr().isEmpty() ?
                            DateUtil.StringToDate(downstream.getDownstreamDateStr()) : null
            );
        }catch (Exception e){ System.out.println(e);}
        return downstream;
    }

    private Downstream toString(Downstream downstream){
        try{
            downstream.setDownstreamDateStr(
                    downstream.getDownstreamDate()!=null ?
                            DateUtil.DateToString(downstream.getDownstreamDate()) : null
            );
        }catch(Exception e) { System.out.println(e); }
        return downstream;
    }


    @Override
    public Downstream findById(String id) {
        return downstreamDAO.findById(id).orElse(null);
    }

    @Override
    public List<Downstream> findAll() {
        return downstreamDAO.findAll().stream().map(this::toString).collect(Collectors.toList());}

    @Override
    public List<Downstream> saveAll(List<Downstream> downstream) {
        return downstreamDAO.saveAll(downstream.stream().map(mobile ->{
            Mapper.setAuditable(toDate(mobile));
            return mobile;
        }).collect(Collectors.toList()));
    }
}
