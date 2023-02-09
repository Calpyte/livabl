package com.calpyte.livabl.controller;

import com.calpyte.livabl.configuration.CustomException;
import com.calpyte.livabl.domain.CapitalGoods;
import com.calpyte.livabl.domain.Upstream;
import com.calpyte.livabl.service.CapitalGoodsService;
import com.calpyte.livabl.service.UpstreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/upstream")
public class UpstreamController {

    @Autowired
    private UpstreamService upstreamService;

    @PostMapping(value = "/save")
    public ResponseEntity<Upstream> save(@RequestBody Upstream upstream) throws CustomException, ParseException {
        return new ResponseEntity<>(upstreamService.save(upstream), HttpStatus.CREATED);
    }

    @PostMapping(value = "/save-all")
    public ResponseEntity<List<Upstream>> saveAll(@RequestBody List<Upstream> upstream){
        return new ResponseEntity<>(upstreamService.saveAll(upstream), HttpStatus.CREATED);
    }

    @GetMapping(value = "/get-all")
    public ResponseEntity<List<Upstream>> findAll() {
        return new ResponseEntity<>(upstreamService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/by-id")
    public ResponseEntity<Upstream> findById(@RequestParam("id") String id) {
        return new ResponseEntity<>(upstreamService.findById(id), HttpStatus.OK);
    }
}
