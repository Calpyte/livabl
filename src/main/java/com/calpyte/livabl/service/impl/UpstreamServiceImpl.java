package com.calpyte.livabl.service.impl;

import com.calpyte.livabl.dao.UpstreamDAO;
import com.calpyte.livabl.domain.Upstream;
import com.calpyte.livabl.service.UpstreamService;
import com.calpyte.livabl.util.DateUtil;
import com.calpyte.livabl.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UpstreamServiceImpl implements UpstreamService {

    @Autowired
    private UpstreamDAO upstreamDAO;

    @Override
    public Upstream save(Upstream upstream) throws ParseException {
        upstream.setDate(
                upstream.getDateStr()!=null&&!upstream.getDateStr().isEmpty() ?
                        DateUtil.StringToDate(upstream.getDateStr()) : null
        );
        Mapper.setAuditable(toDate(upstream));
        return upstreamDAO.save(upstream);
    }

    private Upstream toDate(Upstream upstream) {
        try{
            upstream.setDate(
                    upstream.getDateStr()!=null&&!upstream.getDateStr().isEmpty() ?
                            DateUtil.StringToDate(upstream.getDateStr()) : null
            );
        }catch (Exception e){ System.out.println(e);}
        return upstream;
    }


    @Override
    public Upstream findById(String id) {
        return upstreamDAO.findById(id).orElse(null);
    }

    @Override
    public List<Upstream> findAll() {return upstreamDAO.findAll();}

    @Override
    public List<Upstream> saveAll(List<Upstream> upstream) {
        return upstreamDAO.saveAll(upstream.stream().map(mobile ->{
            Mapper.setAuditable(toDate(mobile));
            return mobile;
        }).collect(Collectors.toList()));
    }
}
