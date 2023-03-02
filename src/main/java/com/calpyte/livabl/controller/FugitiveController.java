package com.calpyte.livabl.controller;

import com.calpyte.livabl.configuration.CustomException;
import com.calpyte.livabl.domain.FugitiveEmission;
import com.calpyte.livabl.domain.FugitiveGases;
import com.calpyte.livabl.domain.StationaryCombustion;
import com.calpyte.livabl.service.FugitiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/fugitive")
public class FugitiveController {
    @Autowired
    private FugitiveService fugitiveService;

    @PostMapping(value = "/save")
    public ResponseEntity<FugitiveEmission> save(@RequestBody FugitiveEmission emission) throws CustomException, ParseException {
        return new ResponseEntity<>(fugitiveService.save(emission), HttpStatus.CREATED);
    }

    @PostMapping(value = "/save-all")
    public ResponseEntity<List<FugitiveEmission>> saveAll(@RequestBody List<FugitiveEmission> emissions){
        return new ResponseEntity<>(fugitiveService.saveAll(emissions), HttpStatus.CREATED);
    }

    @GetMapping(value = "/get-all")
    public ResponseEntity<List<FugitiveEmission>> findAll() {
        return new ResponseEntity<>(fugitiveService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/by-id")
    public ResponseEntity<FugitiveEmission> findById(@RequestParam("id") String id) {
        return new ResponseEntity<>(fugitiveService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/by-user")
    public ResponseEntity<List<FugitiveEmission>> getByUser(@RequestParam("email") String email) {
        return new ResponseEntity<>(fugitiveService.findAllByEmail(email), HttpStatus.OK);
    }

    @GetMapping(value = "/by-gases")
    public ResponseEntity<List<FugitiveGases>> getByGases(@RequestParam("email") String email) {
        return new ResponseEntity<>(fugitiveService.findByUsers(email), HttpStatus.OK);
    }

    @PostMapping(value="/fugitive-gases")
    public ResponseEntity<FugitiveGases> saveGases(@RequestBody FugitiveGases gases) throws CustomException, ParseException {
        return new ResponseEntity<>(fugitiveService.saveGases(gases), HttpStatus.CREATED);
    }

    @GetMapping(value = "/fugitive-get-all")
    public ResponseEntity<List<FugitiveGases>> findAllGases() {
        return new ResponseEntity<>(fugitiveService.findAllGases(), HttpStatus.OK);
    }
}
