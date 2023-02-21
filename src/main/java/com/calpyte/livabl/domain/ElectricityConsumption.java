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

    @JsonProperty("date")
    private Date electricityDate;

    @Transient
    private String electricityDateStr;


    @JsonProperty("quantity")
    private Double energyConsumption;

    private Double co2;
}
