package com.calpyte.livabl.repository;

import com.calpyte.livabl.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository  extends JpaRepository<AppUser, String> {

    AppUser findByEmailAndPassword(String email,String password);

    AppUser findByToken(String token);

    AppUser findByEmail(String email);
}
