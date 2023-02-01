package com.calpyte.livabl.controller;

import com.calpyte.livabl.domain.Message;
import com.calpyte.livabl.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping(value = "/save")
    public ResponseEntity<Message> save(@RequestBody Message message){
        return new ResponseEntity<>(messageService.save(message), HttpStatus.CREATED);
    }

    @PostMapping(value = "/save-all")
    public ResponseEntity<List<Message>> saveAll(@RequestBody List<Message> messages){
        return new ResponseEntity<>(messageService.saveAll(messages), HttpStatus.CREATED);
    }

    @GetMapping(value = "/get-all")
    public ResponseEntity<List<Message>> findAll() {
        return new ResponseEntity<>(messageService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/by-id")
    public ResponseEntity<Message> findById(@RequestParam("id") String id) {
        return new ResponseEntity<>(messageService.findById(id), HttpStatus.OK);
    }
}
