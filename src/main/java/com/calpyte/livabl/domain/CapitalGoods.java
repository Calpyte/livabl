package com.calpyte.livabl.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class CapitalGoods extends AuditableBase{

    @JsonProperty("date")
    private Date capitalDate;

    @Transient
    private String capitalDateStr;

    @JsonProperty("code")
    private String facilityCode;

    @JsonProperty("facility")
    private String facilityName;

    @JsonProperty("byername")
    private String buyerName;

    @JsonProperty("byerlocation")
    private String buyerLocation;

//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "select_transport_id", nullable = true)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","catalogueType"})
    @JsonProperty("transport")
    private String modeOfTransport;

//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "select_vehicle_id", nullable = true)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","catalogueType"})
    @JsonProperty("vehicle")
    private String vehicleType;

    @JsonProperty("distance")
    private Double distanceTravelled;

    @JsonProperty("material")
    private String materialPurchased;

    private String quantity;

    @JsonProperty("facility2")
    private String vehicleFacilityName;

    @JsonProperty("code2")
    private String vehicleFacilityCode;

    @JsonProperty("quantity2")
    private Double vehicleDisTravelled;

//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "v_select_transport", nullable = true)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","catalogueType"})

    @JsonProperty("transport2")
    private String vehicleModeOfTransport;
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "v_select_vehicle", nullable = true)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","catalogueType"})

    @JsonProperty("vehicle2")
    private String vehicleSelectedType;

    @JsonProperty("facility3")
    private String buildingFacilityName;

    @JsonProperty("code3")
    private String buildingFacilityCode;

    @JsonProperty("employeecode")
    private Double buildingSize;

    @JsonProperty("employeename")
    private String buildingLocation;

    private String energy;

    private String email;
}
