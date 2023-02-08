package com.calpyte.livabl.controller;

import com.calpyte.livabl.configuration.CustomException;
import com.calpyte.livabl.domain.CapitalGoods;
import com.calpyte.livabl.service.CapitalGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/capital-goods")
public class CapitalGoodsController {

    @Autowired
    private CapitalGoodsService capitalGoodsService;

    @PostMapping(value = "/save")
    public ResponseEntity<CapitalGoods> save(@RequestBody CapitalGoods capitalGoods) throws CustomException, ParseException {
        return new ResponseEntity<>(capitalGoodsService.save(capitalGoods), HttpStatus.CREATED);
    }

    @PostMapping(value = "/save-all")
    public ResponseEntity<List<CapitalGoods>> saveAll(@RequestBody List<CapitalGoods> capitalGoods){
        return new ResponseEntity<>(capitalGoodsService.saveAll(capitalGoods), HttpStatus.CREATED);
    }

    @GetMapping(value = "/get-all")
    public ResponseEntity<List<CapitalGoods>> findAll() {
        return new ResponseEntity<>(capitalGoodsService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/by-id")
    public ResponseEntity<CapitalGoods> findById(@RequestParam("id") String id) {
        return new ResponseEntity<>(capitalGoodsService.findById(id), HttpStatus.OK);
    }
}
