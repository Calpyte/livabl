package com.calpyte.livabl.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class ElectricityConsumption extends AuditableBase{

    @JsonProperty("code")
    private String facilityCode;

    @JsonProperty("facility")
    private String facilityName;

    @JsonProperty("fuel")
    private String energy;

    private Date electricityDate;

    @Transient
    private String electricityDateStr;

//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "solar_id", nullable = true)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "catalogueType"})
    //private Catalogue solar;

    @JsonProperty("quantity")
    private Double energyConsumption;

    private Double co2;
}
