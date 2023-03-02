package com.calpyte.livabl.repository;

import com.calpyte.livabl.domain.Combustion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CombustionRepository extends JpaRepository<Combustion, String> {
}
