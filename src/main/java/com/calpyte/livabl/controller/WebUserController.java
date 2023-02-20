package com.calpyte.livabl.controller;

import com.calpyte.livabl.domain.Role;
import com.calpyte.livabl.domain.WebUser;
import com.calpyte.livabl.service.RoleService;
import com.calpyte.livabl.service.WebUserService;
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
@RequestMapping("/web-user")
public class WebUserController {

    @Autowired
    private WebUserService userService;

    @PostMapping(value = "/save")
    public ResponseEntity<WebUser> save(@RequestBody WebUser user){
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @PostMapping(value = "/save-all")
    public ResponseEntity<List<WebUser>> saveAll(@RequestBody List<WebUser> users){
        return new ResponseEntity<>(userService.saveAll(users), HttpStatus.CREATED);
    }

    @GetMapping(value = "/get-all")
    public ResponseEntity<List<WebUser>> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/by-id")
    public ResponseEntity<WebUser> findById(@RequestParam("id") String id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }
}
