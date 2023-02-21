package com.calpyte.livabl.service.impl;

import com.calpyte.livabl.dao.UpstreamDAO;
import com.calpyte.livabl.domain.Upstream;
import com.calpyte.livabl.service.UpstreamService;
import com.calpyte.livabl.util.DateUtil;
import com.calpyte.livabl.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UpstreamServiceImpl implements UpstreamService {

    @Autowired
    private UpstreamDAO upstreamDAO;

    @Override
    public Upstream save(Upstream upstream) throws ParseException {
//        upstream.setUpstreamDate(
//                upstream.getUpstreamDateStr()!=null&&!upstream.getUpstreamDateStr().isEmpty() ?
//                        DateUtil.StringToDate(upstream.getUpstreamDateStr()) : null
//        );
        Mapper.setAuditable(upstream);
        return upstreamDAO.save(upstream);
    }

    private Upstream toDate(Upstream upstream) {
        try{
            upstream.setUpstreamDate(
                    upstream.getUpstreamDateStr()!=null&&!upstream.getUpstreamDateStr().isEmpty() ?
                            DateUtil.StringToDate(upstream.getUpstreamDateStr()) : null
            );
        }catch (Exception e){ System.out.println(e);}
        return upstream;
    }

    private Upstream toString(Upstream upstream){
        try{
            upstream.setUpstreamDateStr(
                    upstream.getUpstreamDate()!=null ?
                            DateUtil.DateToString(upstream.getUpstreamDate()) : null
            );
        }catch(Exception e) {System.out.println(e);}
        return upstream;
    }

    @Override
    public Upstream findById(String id) {
        return upstreamDAO.findById(id).orElse(null);
    }

    @Override
    public List<Upstream> findAll() {
        return upstreamDAO.findAll().stream().map(this::toString).collect(Collectors.toList());}

    @Override
    public List<Upstream> saveAll(List<Upstream> upstream) {
        return upstreamDAO.saveAll(upstream.stream().map(mobile ->{
            Mapper.setAuditable(toDate(mobile));
            return mobile;
        }).collect(Collectors.toList()));
    }
}
