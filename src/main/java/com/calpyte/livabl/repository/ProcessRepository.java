package com.calpyte.livabl.repository;

import com.calpyte.livabl.domain.ProcessEmissions;
import com.calpyte.livabl.domain.StationaryCombustion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessRepository extends JpaRepository<ProcessEmissions, String> {

    List<ProcessEmissions> findAllByEmail(String email);
}
