package com.calpyte.livabl.dao;

import com.calpyte.livabl.domain.Upstream;

import java.util.List;
import java.util.Optional;

public interface UpstreamDAO {

    Upstream save(Upstream upstream);

    List<Upstream> saveAll(List<Upstream> upstream);

    List<Upstream> findAll();

    Optional<Upstream> findById(String id);
}
