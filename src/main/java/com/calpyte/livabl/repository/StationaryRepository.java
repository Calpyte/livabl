package com.calpyte.livabl.repository;

import com.calpyte.livabl.domain.StationaryCombustion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationaryRepository extends JpaRepository<StationaryCombustion, String> {

    List<StationaryCombustion> findAllByEmail(String email);
}
