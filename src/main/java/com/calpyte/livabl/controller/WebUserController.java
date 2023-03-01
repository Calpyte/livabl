package com.calpyte.livabl.controller;

import com.calpyte.livabl.configuration.CustomException;
import com.calpyte.livabl.dto.LoginDTO;
import com.calpyte.livabl.dto.RegisterDTO;
import com.calpyte.livabl.dto.ResponseTokenDTO;
import com.calpyte.livabl.service.WebUserService;
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

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class WebUserController {

    @Autowired
    private WebUserService userService;

    @PostMapping(value = "register")
    public ResponseEntity<ResponseTokenDTO> register(@RequestBody RegisterDTO user) throws CustomException {
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @PostMapping(value = "login")
    public ResponseEntity<ResponseTokenDTO> login(@RequestBody LoginDTO loginDTO) throws CustomException {
        return new ResponseEntity<>(userService.login(loginDTO), HttpStatus.CREATED);
    }

    @GetMapping(value = "/logout")
    public ResponseEntity<?> logout(@RequestHeader Map<String,String> headers) {
        userService.logout(headers);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/validate")
    public ResponseEntity<ResponseTokenDTO> validate(@RequestHeader Map<String,String> headers) throws CustomException {
        return new ResponseEntity<>(userService.validateUser(headers), HttpStatus.CREATED);
    }

    @GetMapping(value = "/by-type")
    public ResponseEntity<List<RegisterDTO>> byType(@RequestParam("type") Integer type) {
        return new ResponseEntity<>(userService.findByType(type), HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<?> update(@RequestBody RegisterDTO registerDTO) throws CustomException {
        return new ResponseEntity<>(userService.update(registerDTO), HttpStatus.OK);
    }

    @GetMapping(value = "/by-id")
    public ResponseEntity<RegisterDTO> findById(@RequestParam("id") String id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }
}
