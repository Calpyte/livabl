package com.calpyte.livabl.dao.impl;

import com.calpyte.livabl.dao.AppUserDAO;
import com.calpyte.livabl.domain.AppUser;
import com.calpyte.livabl.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AppUserDAOImpl implements AppUserDAO {
    @Autowired
    private AppUserRepository userRepository;
    @Override
    public AppUser save(AppUser user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<AppUser> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public List<AppUser> findAll() {
        return userRepository.findAll();
    }

    @Override
    public AppUser validate(String email, String pass) {
        return userRepository.findByEmailAndPassword(email,pass);
    }
}
