package com.calpyte.livabl.controller;

import com.calpyte.livabl.service.WebUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ValidateUserController {


    @Autowired
    private WebUserService webUserService;

//
//    @GetMapping(value = "/validuser")
//    public ResponseEntity<ResponseTokenDTO> validuser(@RequestHeader Map<String,String> headers) throws CustomException {
//        return new ResponseEntity<>(webUserService.validateUser(headers,0), HttpStatus.CREATED);
//    }
//
//    @GetMapping(value = "/subuservaliduser")
//    public ResponseEntity<ResponseTokenDTO> validSubUser(@RequestHeader Map<String,String> headers) throws CustomException {
//        return new ResponseEntity<>(webUserService.validateUser(headers,1), HttpStatus.CREATED);
//    }
//
//    @GetMapping(value = "/supervaliduser")
//    public ResponseEntity<ResponseTokenDTO> validAdmin(@RequestHeader Map<String,String> headers) throws CustomException {
//        return new ResponseEntity<>(webUserService.validateUser(headers,2), HttpStatus.CREATED);
//    }

}
