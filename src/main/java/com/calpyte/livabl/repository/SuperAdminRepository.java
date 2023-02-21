package com.calpyte.livabl.repository;


import com.calpyte.livabl.domain.AppUser;
import com.calpyte.livabl.domain.SubUser;
import com.calpyte.livabl.domain.SuperAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperAdminRepository extends JpaRepository<SuperAdmin, String> {

    SuperAdmin findByEmailAndPassword(String email, String password);

    SuperAdmin findByToken(String token);

    SuperAdmin findByEmail(String email);

}
