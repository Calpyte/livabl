package com.calpyte.livabl.repository;

import com.calpyte.livabl.domain.FugitiveGases;
import com.calpyte.livabl.domain.StationaryCombustion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FugitiveGasesRepository extends JpaRepository<FugitiveGases,String> {

    List<FugitiveGases> findAllByEmail(String email);
}
