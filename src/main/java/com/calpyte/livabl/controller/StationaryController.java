package com.calpyte.livabl.controller;

import com.calpyte.livabl.configuration.CustomException;
import com.calpyte.livabl.domain.Combustion;
import com.calpyte.livabl.domain.StationaryCombustion;
import com.calpyte.livabl.domain.WebUser;
import com.calpyte.livabl.repository.WebUserRepository;
import com.calpyte.livabl.service.CombustionService;
import com.calpyte.livabl.service.StationaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stationary")
public class StationaryController {

    @Autowired
    private StationaryService stationaryService;

    @Autowired
    private WebUserRepository webUserRepository;


    @PostMapping(value = "/save")
    public ResponseEntity<StationaryCombustion> save(@RequestBody StationaryCombustion combustion) throws CustomException, ParseException {
        return new ResponseEntity<>(stationaryService.save(combustion), HttpStatus.CREATED);
    }

    @PostMapping(value = "/save-all")
    public ResponseEntity<List<StationaryCombustion>> saveAll(@RequestBody List<StationaryCombustion> combustions){
        return new ResponseEntity<>(stationaryService.saveAll(combustions), HttpStatus.CREATED);
    }

    @GetMapping(value = "/get-all")
    public ResponseEntity<List<StationaryCombustion>> findAll() {
        return new ResponseEntity<>(stationaryService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/by-user")
    public ResponseEntity<List<StationaryCombustion>> getByUser(@RequestParam("email") String email) {
        return new ResponseEntity<>(stationaryService.findAllByEmail(email), HttpStatus.OK);
    }

    @GetMapping(value = "/by-id")
    public ResponseEntity<StationaryCombustion> findById(@RequestParam("id") String id) {
        return new ResponseEntity<>(stationaryService.findById(id), HttpStatus.OK);
    }
}
