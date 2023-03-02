package com.calpyte.livabl.repository;

import com.calpyte.livabl.domain.StationaryCombustion;
import com.calpyte.livabl.domain.Upstream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UpstreamRepository extends JpaRepository<Upstream,String> {

    List<Upstream> findAllByEmail(String email);
}
