package com.calpyte.livabl.dao.impl;

import com.calpyte.livabl.dao.WebUserDAO;
import com.calpyte.livabl.domain.WebUser;
import com.calpyte.livabl.repository.WebUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class WebUserDAOImpl implements WebUserDAO {

    @Autowired
    private WebUserRepository userRepository;

    @Override
    public WebUser save(WebUser user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<WebUser> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public List<WebUser> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<WebUser> saveAll(List<WebUser> users) {
        return userRepository.saveAll(users);
    }
}
