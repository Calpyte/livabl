package com.calpyte.livabl.service.impl;

import com.calpyte.livabl.dao.StationaryDAO;
import com.calpyte.livabl.domain.Combustion;
import com.calpyte.livabl.domain.StationaryCombustion;
import com.calpyte.livabl.service.StationaryService;
import com.calpyte.livabl.util.DateUtil;
import com.calpyte.livabl.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StationaryServiceImpl implements StationaryService {

    @Autowired
    private StationaryDAO stationaryDAO;


    @Override
    public StationaryCombustion save(StationaryCombustion combustion) throws ParseException {
        combustion.setCombustionDate(
                combustion.getDate()!=null&&!combustion.getDate().isEmpty() ?
                        DateUtil.StringToDate(combustion.getDate()) : null
        );
        Mapper.setAuditable(toDate(combustion));
        return stationaryDAO.save(combustion);
    }

    private StationaryCombustion toDate(StationaryCombustion combustion) {
        try{
            combustion.setCombustionDate(
                    combustion.getDate()!=null&&!combustion.getDate().isEmpty() ?
                            DateUtil.StringToDate(combustion.getDate()) : null
            );
        }catch (Exception e){ System.out.println(e);}
        return combustion;
    }


    @Override
    public StationaryCombustion findById(String id) {
        return stationaryDAO.findById(id).orElse(null);
    }

    @Override
    public List<StationaryCombustion> findAll() {
        return stationaryDAO.findAll();
    }

    @Override
    public List<StationaryCombustion> saveAll(List<StationaryCombustion> stationaryCombustions) {
        return stationaryDAO.saveAll(stationaryCombustions.stream().map(stationary ->{
            Mapper.setAuditable(toDate(stationary));
            return stationary;
        }).collect(Collectors.toList()));
    }
}
