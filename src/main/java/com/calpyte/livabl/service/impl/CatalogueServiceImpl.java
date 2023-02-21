package com.calpyte.livabl.service.impl;

import com.calpyte.livabl.dao.CatalogueDAO;
import com.calpyte.livabl.dao.CatalogueTypeDAO;
import com.calpyte.livabl.domain.Catalogue;
import com.calpyte.livabl.dto.CatalogueDTO;
import com.calpyte.livabl.service.CatalogueService;
import com.calpyte.livabl.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatalogueServiceImpl implements CatalogueService {

    @Autowired
    private CatalogueDAO catalogueDAO;

    @Autowired
    private CatalogueTypeDAO typeDAO;

    @Override
    public Catalogue save(CatalogueDTO catalogueDTO) {
        return catalogueDAO.save(getType(catalogueDTO));
    }

    private Catalogue getType(CatalogueDTO catalogueDTO){
        Catalogue catalogue = Mapper.map(catalogueDTO,Catalogue.class);
        catalogue.setCatalogueType(typeDAO.findById(catalogueDTO.getCatalogueType().getId()).get());
        catalogue.setType(catalogue.getCatalogueType().getType());
        return catalogue;
    }


    @Override
    public Catalogue findById(String id) {
        return catalogueDAO.findById(id).orElse(null);
    }

    @Override
    public List<Catalogue> findAll() {
        return catalogueDAO.findAll();
    }

    @Override
    public List<Catalogue> saveAll(List<CatalogueDTO> catalogues) {
        return catalogueDAO.saveAll(catalogues.stream().map(this::getType).collect(Collectors.toList()));
    }

    @Override
    public List<Catalogue> findByType(String type) {
        return catalogueDAO.findByType(type);
    }

    @Override
    public List<Catalogue> findByCatalogueTypeId(String id) {
        return catalogueDAO.findByCatalogueType(id);
    }
}
