package com.calpyte.livabl.dao;

import com.calpyte.livabl.domain.Role;

import java.util.List;
import java.util.Optional;

public interface RoleDAO {
    Role save(Role role);

    Optional<Role> findById(String id);

    List<Role> findAll();

    List<Role> saveAll(List<Role> roles);
}
