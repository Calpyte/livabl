package com.calpyte.livabl.controller;

import com.calpyte.livabl.configuration.CustomException;
import com.calpyte.livabl.domain.Downstream;
import com.calpyte.livabl.domain.FugitiveEmission;
import com.calpyte.livabl.service.DownstreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/downstream")
public class DownstreamController {

    @Autowired
    private DownstreamService downstreamService;

    @PostMapping(value = "/save")
    public ResponseEntity<Downstream> save(@RequestBody Downstream downstream) throws CustomException, ParseException {
        return new ResponseEntity<>(downstreamService.save(downstream), HttpStatus.CREATED);
    }

    @PostMapping(value = "/save-all")
    public ResponseEntity<List<Downstream>> saveAll(@RequestBody List<Downstream> downstream){
        return new ResponseEntity<>(downstreamService.saveAll(downstream), HttpStatus.CREATED);
    }

    @GetMapping(value = "/get-all")
    public ResponseEntity<List<Downstream>> findAll() {
        return new ResponseEntity<>(downstreamService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/by-user")
    public ResponseEntity<List<Downstream>> getByUser(@RequestParam("email") String email) {
        return new ResponseEntity<>(downstreamService.findAllByEmail(email), HttpStatus.OK);
    }

    @GetMapping(value = "/by-id")
    public ResponseEntity<Downstream> findById(@RequestParam("id") String id) {
        return new ResponseEntity<>(downstreamService.findById(id), HttpStatus.OK);
    }
}
