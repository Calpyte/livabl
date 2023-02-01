package com.calpyte.livabl.service.impl;

import com.calpyte.livabl.configuration.CustomException;
import com.calpyte.livabl.dao.CatalogueTypeDAO;
import com.calpyte.livabl.domain.Catalogue;
import com.calpyte.livabl.domain.CatalogueType;
import com.calpyte.livabl.service.CatalogueTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogueTypeServiceImpl implements CatalogueTypeService {
    @Autowired
    private CatalogueTypeDAO typeDAO;

    @Override
    public CatalogueType save(CatalogueType type) throws CustomException {
        validate(type);
        return typeDAO.save(type);
    }

    private void  validate(CatalogueType type) throws CustomException {
        if(type.getType()==null || type.getType().isEmpty()) throw new CustomException("Type should not be empty");
        if(type.getName()==null || type.getName().isEmpty()) throw new CustomException("Name should not be empty");
    }

    @Override
    public CatalogueType findById(String id) {
        return typeDAO.findById(id).orElse(null);
    }

    @Override
    public List<CatalogueType> findAll() {
        return typeDAO.findAll();
    }

    @Override
    public List<CatalogueType> saveAll(List<CatalogueType> types) {
        return typeDAO.saveAll(types);
    }
}
