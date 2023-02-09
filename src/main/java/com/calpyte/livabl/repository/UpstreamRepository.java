package com.calpyte.livabl.repository;

import com.calpyte.livabl.domain.Upstream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpstreamRepository extends JpaRepository<Upstream,String> {
}
