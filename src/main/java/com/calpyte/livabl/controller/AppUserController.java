package com.calpyte.livabl.controller;

import com.calpyte.livabl.configuration.CustomException;
import com.calpyte.livabl.domain.Role;
import com.calpyte.livabl.dto.LoginDTO;
import com.calpyte.livabl.dto.RegisterDTO;
import com.calpyte.livabl.dto.ResponseTokenDTO;
import com.calpyte.livabl.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app-user")
public class AppUserController {

    @Autowired
    private AppUserService userService;

    @PostMapping(value = "register")
    public ResponseEntity<ResponseTokenDTO> register(@RequestBody RegisterDTO user) throws CustomException {
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @PostMapping(value = "login")
    public ResponseEntity<ResponseTokenDTO> login(@RequestBody LoginDTO loginDTO) throws CustomException {
        return new ResponseEntity<>(userService.login(loginDTO), HttpStatus.CREATED);
    }

    @GetMapping(value = "/logout")
    public ResponseEntity<?> logout(@RequestHeader Map<String,String> headers) throws CustomException {
        userService.logout(headers);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping(value = "/get-all")
    public ResponseEntity<List<RegisterDTO>> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/by-id")
    public ResponseEntity<RegisterDTO> findById(@RequestParam("id") String id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }
}
