package com.calpyte.livabl.service.impl;


import com.calpyte.livabl.configuration.CustomException;
import com.calpyte.livabl.dao.AppUserDAO;
import com.calpyte.livabl.domain.AppUser;
import com.calpyte.livabl.domain.SubUser;
import com.calpyte.livabl.dto.LoginDTO;
import com.calpyte.livabl.dto.RegisterDTO;
import com.calpyte.livabl.dto.ResponseTokenDTO;
import com.calpyte.livabl.repository.AppUserRepository;
import com.calpyte.livabl.service.AppUserService;
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
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserDAO userDAO;

    @Autowired
    private AppUserRepository userRepository;

    @Override
    public ResponseTokenDTO save(RegisterDTO registerDTO) throws CustomException {
        AppUser user = Mapper.map(registerDTO,AppUser.class);
        validate(user);
        Mapper.setAuditable(user);
        user.setToken(RandomStringUtils.random(30,true,true));
        userDAO.save(user);
        ResponseTokenDTO responseTokenDTO = Mapper.map(user,ResponseTokenDTO.class);
        return responseTokenDTO;
    }

    private void validate(AppUser user) throws CustomException {
        AppUser appUser =  userRepository.findByEmail(user.getEmail());
        if(appUser!=null && !ObjectUtils.isEmpty(appUser)) throw new CustomException("Email is already registered");
    }


    private RegisterDTO copyToDTO(AppUser user){
        return Mapper.map(user,RegisterDTO.class);
    }

    @Override
    public RegisterDTO findById(String id) {
        Optional<AppUser> user = userDAO.findById(id);
        if(user.isPresent()) return copyToDTO(user.get());
        else return  null;
    }

    @Override
    public List<RegisterDTO> findAll() {
        return userDAO.findAll().stream().map(this::copyToDTO).collect(Collectors.toList());
    }

    @Override
    public ResponseTokenDTO login(LoginDTO login) throws CustomException {
        AppUser user = userDAO.validate(login.getEmail(),login.getPassword());
        if(user != null ) return Mapper.map(user,ResponseTokenDTO.class);
        else throw  new CustomException("Invalid User");
    }

    @Override
    public ResponseTokenDTO validateUser(Map<String, String> headers) throws CustomException {
        String token =  headers.get("authorization");
        if(token!=null && !token.isEmpty()  && !token.equals("null")){
            AppUser user  =  userDAO.findByToken(token);
            if(user!=null && !ObjectUtils.isEmpty(user)) return Mapper.map(user,ResponseTokenDTO.class);
            else throw new CustomException("Invalid User");
        }else{
            throw new CustomException("Invalid User");
        }
    }

    @Override
    public void logout(Map<String, String> headers) {
        String token =  headers.get("authorization");
        if(token!=null && !token.isEmpty()  && !token.equals("null")){
            AppUser user  =  userDAO.findByToken(token);
            if(user!=null && !ObjectUtils.isEmpty(user)) {
                user.setToken(RandomStringUtils.random(30,true,true));
                userDAO.save(user);
            }
        }
    }
}
