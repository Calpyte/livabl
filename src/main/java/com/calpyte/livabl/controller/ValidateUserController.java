package com.calpyte.livabl.controller;

import com.calpyte.livabl.configuration.CustomException;
import com.calpyte.livabl.dto.RegisterDTO;
import com.calpyte.livabl.dto.ResponseTokenDTO;
import com.calpyte.livabl.service.AppUserService;
import com.calpyte.livabl.service.SubUserService;
import com.calpyte.livabl.service.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")
public class ValidateUserController {


    @Autowired
    private AppUserService userService;

    @Autowired
    private SubUserService subUserService;

    @Autowired
    private SuperAdminService adminService;


    @GetMapping(value = "/validuser")
    public ResponseEntity<ResponseTokenDTO> validuser(@RequestHeader Map<String,String> headers) throws CustomException {
        return new ResponseEntity<>(userService.validateUser(headers), HttpStatus.CREATED);
    }

    @GetMapping(value = "/subuservaliduser")
    public ResponseEntity<ResponseTokenDTO> validSubUser(@RequestHeader Map<String,String> headers) throws CustomException {
        return new ResponseEntity<>(subUserService.validateSubUser(headers), HttpStatus.CREATED);
    }

    @GetMapping(value = "/supervaliduser")
    public ResponseEntity<ResponseTokenDTO> validAdmin(@RequestHeader Map<String,String> headers) throws CustomException {
        return new ResponseEntity<>(adminService.validateAdmin(headers), HttpStatus.CREATED);
    }

}
