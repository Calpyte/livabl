package com.calpyte.livabl.service.impl;

import com.calpyte.livabl.dao.StationaryDAO;
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
//        combustion.setCombustionDate(
//                combustion.getCombustionDateStr()!=null&&!combustion.getCombustionDateStr().isEmpty() ?
//                        DateUtil.StringToDate(combustion.getCombustionDateStr()) : null
        //);
        Mapper.setAuditable(combustion);
        return stationaryDAO.save(combustion);
    }

    private StationaryCombustion toDate(StationaryCombustion combustion) {
        try{
            combustion.setCombustionDate(
                    combustion.getCombustionDateStr()!=null&&!combustion.getCombustionDateStr().isEmpty() ?
                            DateUtil.StringToDate(combustion.getCombustionDateStr()) : null
            );
        }catch (Exception e){ System.out.println(e);}
        return combustion;
    }

    private StationaryCombustion toString(StationaryCombustion combustion) {
        try{
            combustion.setCombustionDateStr(
                    combustion.getCombustionDate()!=null ?
                            DateUtil.DateToString(combustion.getCombustionDate()) : null
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
        return stationaryDAO.findAll().stream().map(this::toString).collect(Collectors.toList());
    }

    @Override
    public List<StationaryCombustion> saveAll(List<StationaryCombustion> stationaryCombustions) {
        return stationaryDAO.saveAll(stationaryCombustions.stream().map(stationary ->{
            Mapper.setAuditable(toDate(stationary));
            return stationary;
        }).collect(Collectors.toList()));
    }
}
