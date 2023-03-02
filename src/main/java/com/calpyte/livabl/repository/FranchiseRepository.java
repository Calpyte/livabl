package com.calpyte.livabl.repository;

import com.calpyte.livabl.domain.Franchise;
import com.calpyte.livabl.domain.StationaryCombustion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, String> {

    List<Franchise> findAllByEmail(String email);
}
