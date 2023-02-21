package com.calpyte.livabl.repository;

import com.calpyte.livabl.domain.AppUser;
import com.calpyte.livabl.domain.SubUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SubUserRepository  extends JpaRepository<SubUser, String> {

    SubUser findByEmailAndPassword(String email, String password);

    SubUser findByToken(String token);

    SubUser findByEmail(String email);

}
