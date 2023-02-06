package com.calpyte.livabl.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class ElectricityConsumption extends AuditableBase{
    private String name;
    private String facilityName;
    private Double energy;
    private Date electricityDate;

    @Transient
    private String electricityDateStr;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "solar_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "catalogueType"})
    private Catalogue solar;
}
