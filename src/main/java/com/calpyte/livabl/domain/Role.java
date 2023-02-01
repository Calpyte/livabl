package com.calpyte.livabl.domain;

import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "role")
@Where(clause = "is_deleted = false")
public class Role extends IdentifiableBase{
    private String name;
}
