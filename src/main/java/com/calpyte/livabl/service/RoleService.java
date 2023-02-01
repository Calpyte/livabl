package com.calpyte.livabl.service;
import com.calpyte.livabl.domain.Role;
import com.calpyte.livabl.domain.WebUser;
import java.util.List;

public interface RoleService {
    Role save (Role role);

    Role findById(String id);

    List<Role> findAll();

    List<Role> saveAll(List<Role> roles);
}
