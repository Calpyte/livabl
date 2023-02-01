package com.calpyte.livabl.service.impl;

import com.calpyte.livabl.dao.WebUserDAO;
import com.calpyte.livabl.domain.WebUser;
import com.calpyte.livabl.service.WebUserService;
import com.calpyte.livabl.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WebUserServiceImpl implements WebUserService {

    @Autowired
    private WebUserDAO userDAO;

    @Override
    public WebUser save(WebUser user) {
        Mapper.setAuditable(user);
        return userDAO.save(user);
    }

    @Override
    public WebUser findById(String id) {
        return userDAO.findById(id).orElse(null);
    }

    @Override
    public List<WebUser> findAll() {
        return userDAO.findAll();
    }

    @Override
    public List<WebUser> saveAll(List<WebUser> users) {
        return userDAO.saveAll(users.stream().map(user -> {Mapper.setAuditable(user); return user; }).collect(Collectors.toList()));
    }
}
