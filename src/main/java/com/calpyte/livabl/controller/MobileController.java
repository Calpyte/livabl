package com.calpyte.livabl.controller;

import com.calpyte.livabl.configuration.CustomException;
import com.calpyte.livabl.domain.MobileCombustion;
import com.calpyte.livabl.domain.StationaryCombustion;
import com.calpyte.livabl.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/mobile")
public class MobileController {

    @Autowired
    private MobileService mobileService;

    @PostMapping(value = "/save")
    public ResponseEntity<MobileCombustion> save(@RequestBody MobileCombustion combustion) throws CustomException, ParseException {
        return new ResponseEntity<>(mobileService.save(combustion), HttpStatus.CREATED);
    }

    @PostMapping(value = "/save-all")
    public ResponseEntity<List<MobileCombustion>> saveAll(@RequestBody List<MobileCombustion> combustions){
        return new ResponseEntity<>(mobileService.saveAll(combustions), HttpStatus.CREATED);
    }

    @GetMapping(value = "/get-all")
    public ResponseEntity<List<MobileCombustion>> findAll() {
        return new ResponseEntity<>(mobileService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/by-user")
    public ResponseEntity<List<MobileCombustion>> getByUser(@RequestParam("email") String email) {
        return new ResponseEntity<>(mobileService.findAllByEmail(email), HttpStatus.OK);
    }

    @GetMapping(value = "/by-id")
    public ResponseEntity<MobileCombustion> findById(@RequestParam("id") String id) {
        return new ResponseEntity<>(mobileService.findById(id), HttpStatus.OK);
    }
}
