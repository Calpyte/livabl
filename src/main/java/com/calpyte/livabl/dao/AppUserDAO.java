package com.calpyte.livabl.dao;

import com.calpyte.livabl.domain.AppUser;
import com.calpyte.livabl.dto.LoginDTO;

import java.util.List;
import java.util.Optional;

public interface AppUserDAO {

    AppUser save(AppUser user);

    Optional<AppUser> findById(String id);

    List<AppUser> findAll();

    AppUser validate(String email,String pass);

    AppUser findByToken(String token);
};
