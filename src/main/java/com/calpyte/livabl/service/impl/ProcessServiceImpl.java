package com.calpyte.livabl.service.impl;

import com.calpyte.livabl.dao.ProcessDAO;
import com.calpyte.livabl.domain.ProcessEmissions;
import com.calpyte.livabl.service.ProcessService;
import com.calpyte.livabl.util.DateUtil;
import com.calpyte.livabl.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    private ProcessDAO processDAO;


    @Override
    public ProcessEmissions save(ProcessEmissions emissions) throws ParseException {
//        emissions.setProcessDate(
//                emissions.getProcessDateStr()!=null&&!emissions.getProcessDateStr().isEmpty() ?
//                        DateUtil.StringToDate(emissions.getProcessDateStr()) : null
//        );
        Mapper.setAuditable(emissions);
        return processDAO.save(emissions);
    }

    private ProcessEmissions toDate(ProcessEmissions emissions) {
        try{
            emissions.setProcessDate(
                    emissions.getProcessDateStr()!=null&&!emissions.getProcessDateStr().isEmpty() ?
                            DateUtil.StringToDate(emissions.getProcessDateStr()) : null
            );
        }catch (Exception e){ System.out.println(e);}
        return emissions;
    }

    private ProcessEmissions toString(ProcessEmissions emissions) {
        try{
            emissions.setProcessDateStr(
                    emissions.getProcessDate()!=null ?
                            DateUtil.DateToString(emissions.getProcessDate()) : null
            );
        }catch (Exception e){ System.out.println(e);}
        return emissions;
    }

    @Override
    public ProcessEmissions findById(String id) {
        return processDAO.findById(id).orElse(null);
    }

    @Override
    public List<ProcessEmissions> findAll() {
        return processDAO.findAll().stream().map(this::toString).collect(Collectors.toList());
    }

    @Override
    public List<ProcessEmissions> findAllByEmail(String email) {
        return processDAO.findByUser(email).stream().map(this::toString).collect(Collectors.toList());
    }

    @Override
    public List<ProcessEmissions> saveAll(List<ProcessEmissions> processEmissions) {
        return processDAO.saveAll(processEmissions.stream().map(process ->{
            Mapper.setAuditable(toDate(process));
            return process;
        }).collect(Collectors.toList()));
    }
}
