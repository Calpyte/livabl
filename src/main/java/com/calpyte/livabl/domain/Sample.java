package com.calpyte.livabl.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name="sample")
public class Sample extends AuditableBase{
    private String name;

}
