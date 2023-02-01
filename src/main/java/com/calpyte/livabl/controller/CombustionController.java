package com.calpyte.livabl.controller;

import com.calpyte.livabl.configuration.CustomException;
import com.calpyte.livabl.domain.CatalogueType;
import com.calpyte.livabl.domain.Combustion;
import com.calpyte.livabl.service.CatalogueTypeService;
import com.calpyte.livabl.service.CombustionService;
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
@RequestMapping("/combustion")
public class CombustionController {
    @Autowired
    private CombustionService combustionService;

    @PostMapping(value = "/save")
    public ResponseEntity<Combustion> save(@RequestBody Combustion combustion) throws CustomException {
        return new ResponseEntity<>(combustionService.save(combustion), HttpStatus.CREATED);
    }

    @PostMapping(value = "/save-all")
    public ResponseEntity<List<Combustion>> saveAll(@RequestBody List<Combustion> combustions){
        return new ResponseEntity<>(combustionService.saveAll(combustions), HttpStatus.CREATED);
    }

    @GetMapping(value = "/get-all")
    public ResponseEntity<List<Combustion>> findAll() {
        return new ResponseEntity<>(combustionService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/by-id")
    public ResponseEntity<Combustion> findById(@RequestParam("id") String id) {
        return new ResponseEntity<>(combustionService.findById(id), HttpStatus.OK);
    }
}
