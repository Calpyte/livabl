package com.calpyte.livabl.repository;

import com.calpyte.livabl.domain.MobileCombustion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileRepository extends JpaRepository<MobileCombustion, String> {
}
