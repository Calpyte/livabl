package com.calpyte.livabl.controller;

import com.calpyte.livabl.configuration.CustomException;
import com.calpyte.livabl.domain.Client;
import com.calpyte.livabl.dto.ClientUpdateDTO;
import com.calpyte.livabl.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping(value = "/save")
    public ResponseEntity<Client> save(@RequestBody Client client) throws CustomException {
        return new ResponseEntity<>(clientService.save(client), HttpStatus.CREATED);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<ClientUpdateDTO> update(@RequestBody ClientUpdateDTO updateDTO) throws CustomException {
        return new ResponseEntity<>(clientService.update(updateDTO), HttpStatus.CREATED);
    }

    @PostMapping(value = "/save-all")
    public ResponseEntity<List<Client>> saveAll(@RequestBody List<Client> clients){
        return new ResponseEntity<>(clientService.saveAll(clients), HttpStatus.CREATED);
    }

    @GetMapping(value = "/get-all")
    public ResponseEntity<List<Client>> findAll() {
        return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/by-id")
    public ResponseEntity<Client> findById(@RequestParam("id") String id) {
        return new ResponseEntity<>(clientService.findById(id), HttpStatus.OK);
    }

}
