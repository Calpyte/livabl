package com.calpyte.livabl.repository;

import com.calpyte.livabl.domain.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebUserRepository  extends JpaRepository<WebUser, String> {
}
