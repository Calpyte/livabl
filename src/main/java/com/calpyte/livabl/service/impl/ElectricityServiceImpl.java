package com.calpyte.livabl.service.impl;

import com.calpyte.livabl.dao.ElectricityDAO;
import com.calpyte.livabl.domain.ElectricityConsumption;
import com.calpyte.livabl.service.ElectricityService;
import com.calpyte.livabl.util.DateUtil;
import com.calpyte.livabl.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class ElectricityServiceImpl implements ElectricityService {

    @Autowired
    private ElectricityDAO electricityDAO;

    @Override
    public ElectricityConsumption save(ElectricityConsumption consumption) throws ParseException {
        consumption.setElectricityDate(
               consumption.getElectricityDateStr()!=null&&!consumption.getElectricityDateStr().isEmpty()?
                       DateUtil.StringToDate(consumption.getElectricityDateStr()) : null
        );
        Mapper.setAuditable(toDate(consumption));
        return electricityDAO.save(consumption);
    }

    private ElectricityConsumption toDate(ElectricityConsumption consumption){
        try{
            consumption.setElectricityDate(
                    consumption.getElectricityDateStr()!=null&&!consumption.getElectricityDateStr().isEmpty() ?
                            DateUtil.StringToDate(consumption.getElectricityDateStr()) : null
            );
        }catch (Exception e){ System.out.println(e);}
        return consumption;
    }

    @Override
    public List<ElectricityConsumption> findAll() { return electricityDAO.findAll();}

    @Override
    public ElectricityConsumption findById(String id) { return electricityDAO.findById(id).orElse(null);}
}
