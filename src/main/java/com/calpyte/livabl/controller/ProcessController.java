package com.calpyte.livabl.controller;

import com.calpyte.livabl.configuration.CustomException;
import com.calpyte.livabl.domain.FugitiveEmission;
import com.calpyte.livabl.domain.ProcessEmissions;
import com.calpyte.livabl.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/process")
public class ProcessController {

    @Autowired
    private ProcessService processService;

    @PostMapping(value = "/save")
    public ResponseEntity<ProcessEmissions> save(@RequestBody ProcessEmissions emissions) throws CustomException, ParseException {
        return new ResponseEntity<>(processService.save(emissions), HttpStatus.CREATED);
    }

    @PostMapping(value = "/save-all")
    public ResponseEntity<List<ProcessEmissions>> saveAll(@RequestBody List<ProcessEmissions> emissions){
        return new ResponseEntity<>(processService.saveAll(emissions), HttpStatus.CREATED);
    }

    @GetMapping(value = "/get-all")
    public ResponseEntity<List<ProcessEmissions>> findAll() {
        return new ResponseEntity<>(processService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/by-user")
    public ResponseEntity<List<ProcessEmissions>> getByUser(@RequestParam("email") String email) {
        return new ResponseEntity<>(processService.findAllByEmail(email), HttpStatus.OK);
    }

    @GetMapping(value = "/by-id")
    public ResponseEntity<ProcessEmissions> findById(@RequestParam("id") String id) {
        return new ResponseEntity<>(processService.findById(id), HttpStatus.OK);
    }
}
