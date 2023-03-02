package com.calpyte.livabl.repository;

import com.calpyte.livabl.domain.ElectricityConsumption;
import com.calpyte.livabl.domain.StationaryCombustion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ElectricityRepository extends JpaRepository<ElectricityConsumption, String> {

    List<ElectricityConsumption> findAllByEmail(String email);
}
