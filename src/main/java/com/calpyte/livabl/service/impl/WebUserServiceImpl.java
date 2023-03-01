package com.calpyte.livabl.service.impl;

import com.calpyte.livabl.configuration.CustomException;
import com.calpyte.livabl.domain.WebUser;
import com.calpyte.livabl.dto.LoginDTO;
import com.calpyte.livabl.dto.RegisterDTO;
import com.calpyte.livabl.dto.ResponseTokenDTO;
import com.calpyte.livabl.repository.WebUserRepository;
import com.calpyte.livabl.service.WebUserService;
import com.calpyte.livabl.util.Mapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.naming.ServiceUnavailableException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WebUserServiceImpl implements WebUserService {


    @Autowired
    private WebUserRepository userRepository;

    @Override
    public ResponseTokenDTO save(RegisterDTO registerDTO) throws CustomException {
        WebUser user = Mapper.map(registerDTO,WebUser.class);
        validate(user);
        Mapper.setAuditable(user);
        user.setToken(RandomStringUtils.random(30,true,true));
        userRepository.save(user);
        ResponseTokenDTO responseTokenDTO = Mapper.map(user,ResponseTokenDTO.class);
        return responseTokenDTO;
    }

    @Override
    public ResponseTokenDTO update(RegisterDTO user) throws CustomException {
        WebUser webUser = userRepository.findByEmail(user.getEmail());
        if(webUser!=null){
            webUser.setIsActive(user.getIsActive());
            userRepository.save(webUser);
        }else throw new CustomException("No User Found");
        return Mapper.map(webUser,ResponseTokenDTO.class);
    }


    private RegisterDTO copyToDTO(WebUser user){
        return Mapper.map(user,RegisterDTO.class);
    }

    private void validate(WebUser user) throws CustomException {
        WebUser webUser =  userRepository.findByEmail(user.getEmail());
        if(webUser!=null && !ObjectUtils.isEmpty(webUser)) throw new CustomException("Email is already registered");
    }


    @Override
    public RegisterDTO findById(String id) {
        Optional<WebUser> user = userRepository.findById(id);
        if(user.isPresent()) return copyToDTO(user.get());
        else return  null;
    }

    @Override
    public List<RegisterDTO> findAll() {
        return userRepository.findAll().stream().map(this::copyToDTO).collect(Collectors.toList());
    }

    @Override
    public ResponseTokenDTO login(LoginDTO loginDTO) throws CustomException {
        WebUser user = userRepository.findByEmailAndPassword(loginDTO.getEmail(),loginDTO.getPassword());
        if(user != null){
            if(user.getType() == 0 && !user.getIsActive()) throw new CustomException("User Is InActive");
            if(user.getToken()!=null && !user.getToken().isEmpty()) {
                return Mapper.map(user,ResponseTokenDTO.class);
            }
            else {
                user.setToken(RandomStringUtils.random(30,true,true));
                WebUser webUser = userRepository.save(user);
                return Mapper.map(webUser,ResponseTokenDTO.class);
            }
        }
        else throw  new CustomException("No User Found");
    }

    @Override
    public ResponseTokenDTO validateUser(Map<String, String> headers) throws CustomException {
        String token =  headers.get("authorization");
        if(token!=null && !token.isEmpty() && !token.equals("null")){
            WebUser user  =  userRepository.findByToken(token);
              if(user!=null && !ObjectUtils.isEmpty(user)) {
                  return Mapper.map(user,ResponseTokenDTO.class);
              }
              else throw new CustomException("No User Found");
        }else{
            throw new CustomException("Token Is Empty");
        }
    }

    @Override
    public void logout(Map<String, String> headers) {
        String token =  headers.get("authorization");
        if(token!=null && !token.isEmpty()  && !token.equals("null")){
            WebUser user  =  userRepository.findByToken(token);
            if(user!=null && !ObjectUtils.isEmpty(user)) {
                user.setToken(RandomStringUtils.random(30,true,true));
                userRepository.save(user);
            }
        }
    }

    @Override
    public List<RegisterDTO> findByType(Integer type) {
        return userRepository.findByType(type).stream().map(this::copyToDTO).collect(Collectors.toList());
    }

}
