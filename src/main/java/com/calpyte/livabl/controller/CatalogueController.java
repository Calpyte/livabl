package com.calpyte.livabl.controller;

import com.calpyte.livabl.domain.Catalogue;
import com.calpyte.livabl.dto.CatalogueDTO;
import com.calpyte.livabl.service.CatalogueService;
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
@RequestMapping("/catalogue")
public class CatalogueController {

    @Autowired
    private CatalogueService catalogueService;

    @PostMapping(value = "/save")
    public ResponseEntity<Catalogue> save(@RequestBody CatalogueDTO catalogue){
        return new ResponseEntity<>(catalogueService.save(catalogue), HttpStatus.CREATED);
    }

    @PostMapping(value = "/save-all")
    public ResponseEntity<List<Catalogue>> saveAll(@RequestBody List<CatalogueDTO> catalogues){
        return new ResponseEntity<>(catalogueService.saveAll(catalogues), HttpStatus.CREATED);
    }

    @GetMapping(value = "/get-all")
    public ResponseEntity<List<Catalogue>> findAll() {
        return new ResponseEntity<>(catalogueService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/by-id")
    public ResponseEntity<Catalogue> findById(@RequestParam("id") String id) {
        return new ResponseEntity<>(catalogueService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/by-type")
    public ResponseEntity<List<Catalogue>> findByType(@RequestParam("type") String type) {
        return new ResponseEntity<>(catalogueService.findByType(type), HttpStatus.OK);
    }

    @GetMapping(value = "/by-type-id")
    public ResponseEntity<List<Catalogue>> findByTypeId(@RequestParam("id") String id) {
        return new ResponseEntity<>(catalogueService.findByCatalogueTypeId(id), HttpStatus.OK);
    }
}
