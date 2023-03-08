package com.calpyte.livabl.repository;

import com.calpyte.livabl.domain.FugitiveEmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FugitiveRepository extends JpaRepository<FugitiveEmission, String> {

    List<FugitiveEmission> findAllByEmail(String email);
}
