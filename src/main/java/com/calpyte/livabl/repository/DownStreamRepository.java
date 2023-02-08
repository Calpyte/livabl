package com.calpyte.livabl.repository;

import com.calpyte.livabl.domain.Downstream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DownStreamRepository extends JpaRepository<Downstream, String> {
}
