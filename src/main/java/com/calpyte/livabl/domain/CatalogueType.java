package com.calpyte.livabl.domain;

import com.keycloak.connector.config.EnableKeycloak;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "catalogue_type")
public class CatalogueType extends IdentifiableBase{
    private String name;
    private String type;
}
