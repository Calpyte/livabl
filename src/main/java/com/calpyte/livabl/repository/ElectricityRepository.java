package com.calpyte.livabl.repository;

import com.calpyte.livabl.domain.ElectricityConsumption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectricityRepository extends JpaRepository<ElectricityConsumption, String> {
}
