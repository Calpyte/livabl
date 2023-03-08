package com.calpyte.livabl.service.impl;

import com.calpyte.livabl.dao.CombustionDAO;
import com.calpyte.livabl.domain.Combustion;
import com.calpyte.livabl.dto.ExcelDTO;
import com.calpyte.livabl.service.CombustionService;
import com.calpyte.livabl.util.DateUtil;
import com.calpyte.livabl.util.ExcelWriter;
import com.calpyte.livabl.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CombustionServiceImpl implements CombustionService {
    @Autowired
    private CombustionDAO combustionDAO;

    @Override
    public Combustion save(Combustion combustion) throws ParseException {
        combustion.setCombustionDate(
                combustion.getCombustionDateStr()!=null&&!combustion.getCombustionDateStr().isEmpty() ?
                        DateUtil.StringToDate(combustion.getCombustionDateStr()) : null
        );
        Mapper.setAuditable(toDate(combustion));
        return combustionDAO.save(combustion);
    }

    private Combustion toDate(Combustion combustion) {
        try{
            combustion.setCombustionDate(
                    combustion.getCombustionDateStr()!=null&&!combustion.getCombustionDateStr().isEmpty() ?
                            DateUtil.StringToDate(combustion.getCombustionDateStr()) : null
            );
        }catch (Exception e){ System.out.println(e);}
        return combustion;
    }

    @Override
    public Combustion findById(String id) {
        return combustionDAO.findById(id).orElse(null);
    }

    @Override
    public List<Combustion> findAll() {
        return combustionDAO.findAll();
    }

    @Override
    public List<Combustion> saveAll(List<Combustion> combustions) {
        return combustionDAO.saveAll(combustions.stream().map(combustion -> {Mapper.setAuditable(toDate(combustion)); return combustion;}).collect(Collectors.toList()));
    }

    @Override
    public ByteArrayInputStream downloadExcel(ExcelDTO exportDTO) throws IOException {
            return new ByteArrayInputStream(ExcelWriter.downloadExcel(exportDTO).toByteArray());
    }
}
