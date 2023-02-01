package com.calpyte.livabl.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "role")
public class Role extends IdentifiableBase{
    private String name;
}
