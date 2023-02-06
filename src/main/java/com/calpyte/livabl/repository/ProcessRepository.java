package com.calpyte.livabl.repository;

import com.calpyte.livabl.domain.ProcessEmissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessRepository extends JpaRepository<ProcessEmissions, String> {
}
