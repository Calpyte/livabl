package com.calpyte.livabl.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.Date;

@Data
@Entity
public class Franchise extends AuditableBase{

    @JsonProperty("date")
    private Date franchiseDate;

    @Transient
    private String franchiseDateStr;

    @JsonProperty("name")
    private String userName;

    @JsonProperty("time")
    private String timeUsage;

    @JsonProperty("product")
    private String productName;

    private String disposal;

    @JsonProperty("asset")
    private String assetType;

    @JsonProperty("period")
    private String leasePeriod;

    @JsonProperty("franchisename")
    private String franchiseName;

    @JsonProperty("franchiseperiod")
    private String franchiseLocation;

    @JsonProperty("investment")
    private String investmentType;

    private String location;
}
