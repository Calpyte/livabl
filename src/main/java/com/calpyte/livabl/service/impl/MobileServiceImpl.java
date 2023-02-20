package com.calpyte.livabl.service.impl;

import com.calpyte.livabl.dao.MobileDAO;
import com.calpyte.livabl.domain.MobileCombustion;
import com.calpyte.livabl.service.MobileService;
import com.calpyte.livabl.util.DateUtil;
import com.calpyte.livabl.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MobileServiceImpl implements MobileService {

    @Autowired
    private MobileDAO mobileDAO;


    @Override
    public MobileCombustion save(MobileCombustion combustion) throws ParseException {
//        combustion.setMblDate(
//                combustion.getMblDateStr()!=null&&!combustion.getMblDateStr().isEmpty() ?
//                        DateUtil.StringToDate(combustion.getMblDateStr()) : null
//        );
        Mapper.setAuditable(combustion);
        return mobileDAO.save(combustion);
    }

    private MobileCombustion toDate(MobileCombustion combustion) {
        try{
            combustion.setMobileDate(
                    combustion.getMobileDateStr()!=null&&!combustion.getMobileDateStr().isEmpty() ?
                            DateUtil.StringToDate(combustion.getMobileDateStr()) : null
            );
        }catch (Exception e){ System.out.println(e);}
        return combustion;
    }

    private MobileCombustion toString(MobileCombustion combustion) {
        try{
            combustion.setMobileDateStr(
                    combustion.getMobileDate()!=null ?
                            DateUtil.DateToString(combustion.getMobileDate()) : null
            );
        }catch (Exception e){ System.out.println(e);}
        return combustion;
    }


    @Override
    public MobileCombustion findById(String id) {
        return mobileDAO.findById(id).orElse(null);
    }

    @Override
    public List<MobileCombustion> findAll() {
        return mobileDAO.findAll().stream().map(this::toString).collect(Collectors.toList());}

    @Override
    public List<MobileCombustion> saveAll(List<MobileCombustion> mobileCombustions) {
        return mobileDAO.saveAll(mobileCombustions.stream().map(mobile ->{
            Mapper.setAuditable(toDate(mobile));
            return mobile;
        }).collect(Collectors.toList()));
    }
}
