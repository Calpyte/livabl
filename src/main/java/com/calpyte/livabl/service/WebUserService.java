package com.calpyte.livabl.service;

import com.calpyte.livabl.domain.WebUser;

import java.util.List;

public interface WebUserService {

    WebUser save (WebUser user);

    WebUser findById(String id);

    List<WebUser> findAll();

    List<WebUser> saveAll(List<WebUser> users);
}
