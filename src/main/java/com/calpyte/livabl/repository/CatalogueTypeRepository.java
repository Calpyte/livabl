package com.calpyte.livabl.repository;

import com.calpyte.livabl.domain.CatalogueType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogueTypeRepository extends JpaRepository<CatalogueType, String> {

}
