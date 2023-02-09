package com.calpyte.livabl.repository;

import com.calpyte.livabl.domain.FugitiveEmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FugitiveRepository extends JpaRepository<FugitiveEmission, String> {
}
