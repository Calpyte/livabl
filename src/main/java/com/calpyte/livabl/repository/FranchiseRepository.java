package com.calpyte.livabl.repository;

import com.calpyte.livabl.domain.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, String> {
}
