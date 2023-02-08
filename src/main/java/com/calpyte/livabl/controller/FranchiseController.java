package com.calpyte.livabl.controller;

import com.calpyte.livabl.configuration.CustomException;
import com.calpyte.livabl.domain.CapitalGoods;
import com.calpyte.livabl.domain.Franchise;
import com.calpyte.livabl.service.FranchiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/franchise")
public class FranchiseController {

    @Autowired
    private FranchiseService franchiseService;

    @PostMapping(value = "/save")
    public ResponseEntity<Franchise> save(@RequestBody Franchise franchise) throws CustomException, ParseException {
        return new ResponseEntity<>(franchiseService.save(franchise), HttpStatus.CREATED);
    }

    @PostMapping(value = "/save-all")
    public ResponseEntity<List<Franchise>> saveAll(@RequestBody List<Franchise> franchise){
        return new ResponseEntity<>(franchiseService.saveAll(franchise), HttpStatus.CREATED);
    }

    @GetMapping(value = "/get-all")
    public ResponseEntity<List<Franchise>> findAll() {
        return new ResponseEntity<>(franchiseService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/by-id")
    public ResponseEntity<Franchise> findById(@RequestParam("id") String id) {
        return new ResponseEntity<>(franchiseService.findById(id), HttpStatus.OK);
    }
}
