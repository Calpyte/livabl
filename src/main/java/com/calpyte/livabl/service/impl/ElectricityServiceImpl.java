package com.calpyte.livabl.service.impl;

import com.calpyte.livabl.dao.ElectricityDAO;
import com.calpyte.livabl.domain.ElectricityConsumption;
import com.calpyte.livabl.domain.ProcessEmissions;
import com.calpyte.livabl.service.ElectricityService;
import com.calpyte.livabl.util.DateUtil;
import com.calpyte.livabl.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ElectricityServiceImpl implements ElectricityService {

    @Autowired
    private ElectricityDAO electricityDAO;

    @Override
    public ElectricityConsumption save(ElectricityConsumption consumption) throws ParseException {
//        consumption.setElectricityDate(
//               consumption.getElectricityDateStr()!=null&&!consumption.getElectricityDateStr().isEmpty()?
//                       DateUtil.StringToDate(consumption.getElectricityDateStr()) : null
//        );
        Mapper.setAuditable(consumption);
        return electricityDAO.save(consumption);
    }

    @Override
    public List<ElectricityConsumption> findAllByEmail(String email) {
        return electricityDAO.findByUser(email).stream().map(this::toString).collect(Collectors.toList());
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

    private ElectricityConsumption toString(ElectricityConsumption electricityConsumption) {
        try{
            electricityConsumption.setElectricityDateStr(
                    electricityConsumption.getElectricityDate()!=null ?
                            DateUtil.DateToString(electricityConsumption .getElectricityDate()) : null
            );
        }catch (Exception e){ System.out.println(e);}
        return electricityConsumption;
    }

    @Override
    public List<ElectricityConsumption> findAll() {
        return electricityDAO.findAll().stream().map(this::toString).collect(Collectors.toList());}

    @Override
    public ElectricityConsumption findById(String id) { return electricityDAO.findById(id).orElse(null);}
}
