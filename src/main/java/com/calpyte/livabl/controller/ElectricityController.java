package com.calpyte.livabl.controller;

import com.calpyte.livabl.configuration.CustomException;
import com.calpyte.livabl.domain.ElectricityConsumption;
import com.calpyte.livabl.service.ElectricityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/electricity")
public class ElectricityController {

    @Autowired
    private ElectricityService electricityService;

    @PostMapping(value = "/save")
    public ResponseEntity<ElectricityConsumption> save(@RequestBody ElectricityConsumption consumption) throws CustomException, ParseException {
        return new ResponseEntity<>(electricityService.save(consumption), HttpStatus.CREATED);
    }

//    @PostMapping(value = "/save-all")
//    public ResponseEntity<List<ElectricityConsumption>> saveAll(@RequestBody List<ElectricityConsumption> consumptions){
//        return new ResponseEntity<>(electricityService.saveAll(consumptions), HttpStatus.CREATED);
//    }

    @GetMapping(value = "/get-all")
    public ResponseEntity<List<ElectricityConsumption>> findAll() {
        return new ResponseEntity<>(electricityService.findAll(),HttpStatus.OK);
    }

    @GetMapping(value ="/by-id")
    public ResponseEntity<ElectricityConsumption> findById(@RequestParam("id") String id){
        return new ResponseEntity<>(electricityService.findById(id), HttpStatus.OK);
    }
}
