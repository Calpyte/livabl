package com.calpyte.livabl.repository;

import com.calpyte.livabl.domain.FugitiveGases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FugitiveGasesRepository extends JpaRepository<FugitiveGases,String> {
}
