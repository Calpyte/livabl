package com.calpyte.livabl.service.impl;

import com.calpyte.livabl.configuration.CustomException;
import com.calpyte.livabl.domain.AppUser;
import com.calpyte.livabl.domain.SubUser;
import com.calpyte.livabl.domain.SuperAdmin;
import com.calpyte.livabl.dto.LoginDTO;
import com.calpyte.livabl.dto.RegisterDTO;
import com.calpyte.livabl.dto.ResponseTokenDTO;
import com.calpyte.livabl.repository.SubUserRepository;
import com.calpyte.livabl.service.SubUserService;
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
public class SubUserServiceImpl implements SubUserService {


    @Autowired
    private SubUserRepository userRepository;

    @Override
    public ResponseTokenDTO save(RegisterDTO registerDTO) throws CustomException {
        SubUser user = Mapper.map(registerDTO,SubUser.class);
        validate(user);
        Mapper.setAuditable(user);
        user.setToken(RandomStringUtils.random(30,true,true));
        userRepository.save(user);
        ResponseTokenDTO responseTokenDTO = Mapper.map(user,ResponseTokenDTO.class);
        return responseTokenDTO;
    }

    private RegisterDTO copyToDTO(SubUser user){
        return Mapper.map(user,RegisterDTO.class);
    }

    private void validate(SubUser user) throws CustomException {
       SubUser subUser =  userRepository.findByEmail(user.getEmail());
       if(subUser!=null && !ObjectUtils.isEmpty(subUser)) throw new CustomException("Email is already registered");
    }


    @Override
    public RegisterDTO findById(String id) {
        Optional<SubUser> user = userRepository.findById(id);
        if(user.isPresent()) return copyToDTO(user.get());
        else return  null;
    }

    @Override
    public List<RegisterDTO> findAll() {
        return userRepository.findAll().stream().map(this::copyToDTO).collect(Collectors.toList());
    }

    @Override
    public ResponseTokenDTO login(LoginDTO loginDTO) throws CustomException {
        SubUser user = userRepository.findByEmailAndPassword(loginDTO.getEmail(),loginDTO.getPassword());
        if(user != null ) return Mapper.map(user,ResponseTokenDTO.class);
        else throw  new CustomException("Invalid User");
    }

    @Override
    public ResponseTokenDTO validateSubUser(Map<String, String> headers) throws CustomException {
        String token =  headers.get("authorization");
        if(token!=null && !token.isEmpty() && !token.equals("null")){
            SubUser subUser  =  userRepository.findByToken(token);
            if(subUser!=null && !ObjectUtils.isEmpty(subUser)) return Mapper.map(subUser,ResponseTokenDTO.class);
            else throw new CustomException("Invalid User");
        }else{
            throw new CustomException("Invalid User");
        }
    }
}
