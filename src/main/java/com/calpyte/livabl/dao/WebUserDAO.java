package com.calpyte.livabl.dao;

import com.calpyte.livabl.domain.WebUser;

import java.util.List;
import java.util.Optional;

public interface WebUserDAO {
    WebUser save(WebUser user);

    Optional<WebUser> findById(String id);

    List<WebUser> findAll();

    List<WebUser> saveAll(List<WebUser> users);

    List<WebUser> findByType(Integer type);
}
