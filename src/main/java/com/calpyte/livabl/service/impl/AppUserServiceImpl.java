package com.calpyte.livabl.service.impl;


import com.calpyte.livabl.configuration.CustomException;
import com.calpyte.livabl.dao.AppUserDAO;
import com.calpyte.livabl.domain.AppUser;
import com.calpyte.livabl.dto.LoginDTO;
import com.calpyte.livabl.dto.RegisterDTO;
import com.calpyte.livabl.service.AppUserService;
import com.calpyte.livabl.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserDAO userDAO;

    @Override
    public RegisterDTO save(RegisterDTO registerDTO) {
        AppUser user = Mapper.map(registerDTO,AppUser.class);
        Mapper.setAuditable(user);
        userDAO.save(user);
        return registerDTO;
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
    public LoginDTO login(LoginDTO login) throws CustomException {
        AppUser user = userDAO.validate(login.getEmail(),login.getPassword());
        if(user != null ) return login;
        else throw  new CustomException("Invalid");
    }
}
