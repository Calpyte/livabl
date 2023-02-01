package com.calpyte.livabl.controller;

import com.calpyte.livabl.configuration.CustomException;
import com.calpyte.livabl.domain.CatalogueType;
import com.calpyte.livabl.service.CatalogueTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalogue-type")
public class CatalogueTypeController {

    @Autowired
    private CatalogueTypeService typeService;

    @PostMapping(value = "/save")
    public ResponseEntity<CatalogueType> save(@RequestBody CatalogueType type) throws CustomException {
        return new ResponseEntity<>(typeService.save(type), HttpStatus.CREATED);
    }

    @PostMapping(value = "/save-all")
    public ResponseEntity<List<CatalogueType>> saveAll(@RequestBody List<CatalogueType> types){
        return new ResponseEntity<>(typeService.saveAll(types), HttpStatus.CREATED);
    }

    @GetMapping(value = "/get-all")
    public ResponseEntity<List<CatalogueType>> findAll() {
        return new ResponseEntity<>(typeService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/by-id")
    public ResponseEntity<CatalogueType> findById(@RequestParam("id") String id) {
        return new ResponseEntity<>(typeService.findById(id), HttpStatus.OK);
    }
}
