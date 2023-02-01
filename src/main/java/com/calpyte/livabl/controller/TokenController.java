package com.calpyte.livabl.controller;

import com.calpyte.livabl.dto.RegistrationResponse;
import com.calpyte.livabl.dto.UserBasicDTO;
import com.calpyte.livabl.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/unsecure")
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @PostMapping(value = "/token")
    private ResponseEntity<?> getTokenByRefresh(@RequestBody Map<String, String> tokenMap) throws IOException {
        return new ResponseEntity<>(tokenService.getToken(tokenMap.get("token")), HttpStatus.OK);
    }

    @PostMapping(value = "/access/token")
    private ResponseEntity<RegistrationResponse> getAccessToken(@RequestBody UserBasicDTO user) throws IOException {
        return new ResponseEntity<>(tokenService.getAccessToken(user), HttpStatus.OK);
    }
}
