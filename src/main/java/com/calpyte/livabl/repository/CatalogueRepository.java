package com.calpyte.livabl.repository;

import com.calpyte.livabl.domain.Catalogue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogueRepository  extends JpaRepository<Catalogue, String> {

    List<Catalogue> findByType(String type);

    List<Catalogue> findByCatalogueTypeId(String id);
}
