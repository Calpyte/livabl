package com.calpyte.livabl.dao.impl;

import com.calpyte.livabl.dao.RoleDAO;
import com.calpyte.livabl.domain.Role;
import com.calpyte.livabl.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RoleDAOImpl implements RoleDAO {
    @Autowired
    private RoleRepository roleRepository;


    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Optional<Role> findById(String id) {
        return roleRepository.findById(id);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public List<Role> saveAll(List<Role> roles) {
        return roleRepository.saveAll(roles);
    }
}
