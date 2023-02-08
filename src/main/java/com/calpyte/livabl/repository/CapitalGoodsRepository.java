package com.calpyte.livabl.repository;

import com.calpyte.livabl.domain.CapitalGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapitalGoodsRepository extends JpaRepository<CapitalGoods, String> {
}
