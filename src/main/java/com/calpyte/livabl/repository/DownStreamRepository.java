package com.calpyte.livabl.repository;

import com.calpyte.livabl.domain.Downstream;
import com.calpyte.livabl.domain.StationaryCombustion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DownStreamRepository extends JpaRepository<Downstream, String> {

    List<Downstream> findAllByEmail(String email);
}
