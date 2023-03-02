package com.calpyte.livabl.service.impl;

import com.calpyte.livabl.dao.RoleDAO;
import com.calpyte.livabl.domain.Role;
import com.calpyte.livabl.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    @Override
    public Role save(Role role) {
        return roleDAO.save(role);
    }

    @Override
    public Role findById(String id) {
        return roleDAO.findById(id).orElse(null);
    }

    @Override
    public List<Role> findAll() {
        return roleDAO.findAll();
    }

    @Override
    public List<Role> saveAll(List<Role> roles) {
        return roleDAO.saveAll(roles);
    }
}
