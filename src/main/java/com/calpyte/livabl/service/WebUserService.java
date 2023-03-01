package com.calpyte.livabl.service;

import com.calpyte.livabl.configuration.CustomException;
import com.calpyte.livabl.dto.LoginDTO;
import com.calpyte.livabl.dto.RegisterDTO;
import com.calpyte.livabl.dto.ResponseTokenDTO;

import java.util.List;
import java.util.Map;

public interface WebUserService {

    ResponseTokenDTO save(RegisterDTO registerDTO) throws CustomException;

    ResponseTokenDTO update(RegisterDTO registerDTO) throws CustomException;

    RegisterDTO findById(String id);

    List<RegisterDTO> findAll();

    ResponseTokenDTO login(LoginDTO loginDTO) throws CustomException;

    ResponseTokenDTO validateUser(Map<String,String> headers) throws CustomException;

    void logout(Map<String,String> headers);

    List<RegisterDTO> findByType(Integer type);


}
