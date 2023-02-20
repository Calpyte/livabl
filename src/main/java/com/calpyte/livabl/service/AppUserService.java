package com.calpyte.livabl.service;

import com.calpyte.livabl.configuration.CustomException;
import com.calpyte.livabl.dto.LoginDTO;
import com.calpyte.livabl.dto.RegisterDTO;

import java.util.List;

public interface AppUserService {

    RegisterDTO save(RegisterDTO registerDTO);

    RegisterDTO findById(String id);

    List<RegisterDTO> findAll();

    LoginDTO login(LoginDTO loginDTO) throws CustomException;
}
