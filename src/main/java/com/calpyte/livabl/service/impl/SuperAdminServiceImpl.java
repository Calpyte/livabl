package com.calpyte.livabl.service.impl;


import com.calpyte.livabl.configuration.CustomException;
import com.calpyte.livabl.domain.SubUser;
import com.calpyte.livabl.domain.SuperAdmin;
import com.calpyte.livabl.dto.LoginDTO;
import com.calpyte.livabl.dto.RegisterDTO;
import com.calpyte.livabl.dto.ResponseTokenDTO;
import com.calpyte.livabl.repository.SubUserRepository;
import com.calpyte.livabl.repository.SuperAdminRepository;
import com.calpyte.livabl.service.SuperAdminService;
import com.calpyte.livabl.util.Mapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class SuperAdminServiceImpl implements SuperAdminService {

    @Autowired
    private SuperAdminRepository adminRepository;

    @Override
    public ResponseTokenDTO save(RegisterDTO registerDTO) throws CustomException {
        SuperAdmin user = Mapper.map(registerDTO,SuperAdmin.class);
        validate(user);
        Mapper.setAuditable(user);
        user.setToken(RandomStringUtils.random(30,true,true));
        adminRepository.save(user);
        ResponseTokenDTO responseTokenDTO = Mapper.map(user,ResponseTokenDTO.class);
        return responseTokenDTO;
    }

    private void validate(SuperAdmin user) throws CustomException {
        SuperAdmin superAdmin =  adminRepository.findByEmail(user.getEmail());
        if(superAdmin!=null && !ObjectUtils.isEmpty(superAdmin)) throw new CustomException("Email is already registered");
    }

    private RegisterDTO copyToDTO(SuperAdmin user){
        return Mapper.map(user,RegisterDTO.class);
    }

    @Override
    public RegisterDTO findById(String id) {
        Optional<SuperAdmin> user = adminRepository.findById(id);
        if(user.isPresent()) return copyToDTO(user.get());
        else return  null;
    }

    @Override
    public List<RegisterDTO> findAll() {
        return adminRepository.findAll().stream().map(this::copyToDTO).collect(Collectors.toList());
    }

    @Override
    public ResponseTokenDTO login(LoginDTO loginDTO) throws CustomException {
        SuperAdmin user = adminRepository.findByEmailAndPassword(loginDTO.getEmail(),loginDTO.getPassword());
        if(user != null ) return Mapper.map(user,ResponseTokenDTO.class);
        else throw  new CustomException("Invalid User");
    }

    @Override
    public ResponseTokenDTO validateAdmin(Map<String, String> headers) throws CustomException {
        String token =  headers.get("authorization");
        if(token!=null && !token.isEmpty()  && !token.equals("null")){
            SuperAdmin  superAdmin  =  adminRepository.findByToken(token);
            if(superAdmin!=null && !ObjectUtils.isEmpty(superAdmin)) return Mapper.map(superAdmin,ResponseTokenDTO.class);
            else throw new CustomException("Invalid User");
        }else{
            throw new CustomException("Invalid User");
        }
    }

    @Override
    public void logout(Map<String, String> headers) {
        String token =  headers.get("authorization");
        if(token!=null && !token.isEmpty()  && !token.equals("null")){
            SuperAdmin user  =  adminRepository.findByToken(token);
            if(user!=null && !ObjectUtils.isEmpty(user)) {
                user.setToken(RandomStringUtils.random(30,true,true));
                adminRepository.save(user);
            }
        }
    }
}
