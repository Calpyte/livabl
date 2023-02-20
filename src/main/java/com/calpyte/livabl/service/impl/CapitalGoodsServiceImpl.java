package com.calpyte.livabl.service.impl;

import com.calpyte.livabl.dao.CapitalGoodsDAO;
import com.calpyte.livabl.domain.CapitalGoods;
import com.calpyte.livabl.service.CapitalGoodsService;
import com.calpyte.livabl.util.DateUtil;
import com.calpyte.livabl.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CapitalGoodsServiceImpl implements CapitalGoodsService {

    @Autowired
    private CapitalGoodsDAO capitalGoodsDAO;

    @Override
    public CapitalGoods save(CapitalGoods capitalGoods) throws ParseException {
//        capitalGoods.setCapitalDate(
//                capitalGoods.getCapitalDateStr()!=null&&!capitalGoods.getCapitalDateStr().isEmpty() ?
//                        DateUtil.StringToDate(capitalGoods.getCapitalDateStr()) : null
//        );
        Mapper.setAuditable(capitalGoods);
        return capitalGoodsDAO.save(capitalGoods);
    }

    private CapitalGoods toDate(CapitalGoods capitalGoods) {
        try{
            capitalGoods.setCapitalDate(
                    capitalGoods.getCapitalDateStr()!=null&&!capitalGoods.getCapitalDateStr().isEmpty() ?
                            DateUtil.StringToDate(capitalGoods.getCapitalDateStr()) : null
            );
        }catch (Exception e){ System.out.println(e);}
        return capitalGoods;
    }


    private CapitalGoods toString(CapitalGoods capitalGoods) {
        try{
            capitalGoods.setCapitalDateStr(
                    capitalGoods.getCapitalDate()!=null ?
                            DateUtil.DateToString(capitalGoods.getCreatedDate()) : null
            );
        }catch (Exception e){ System.out.println(e);}
        return capitalGoods;
    }


    @Override
    public CapitalGoods findById(String id) {
        return capitalGoodsDAO.findById(id).orElse(null);
    }

    @Override
    public List<CapitalGoods> findAll() {
        return capitalGoodsDAO.findAll().stream().map(this::toString).collect(Collectors.toList());}

    @Override
    public List<CapitalGoods> saveAll(List<CapitalGoods> capitalGoods) {
        return capitalGoodsDAO.saveAll(capitalGoods.stream().map(mobile ->{
            Mapper.setAuditable(toDate(mobile));
            return mobile;
        }).collect(Collectors.toList()));
    }
}
