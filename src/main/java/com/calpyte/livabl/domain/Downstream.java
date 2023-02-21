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
public class Downstream extends AuditableBase{

    @JsonProperty("date")
    private Date downstreamDate;

    @Transient
    private String downstreamDateStr;

    @JsonProperty("code")
    private String facilityCode;

    @JsonProperty("byername")
    private String buyerName;

    @JsonProperty("byerlocation")
    private String buyerLocation;

    @JsonProperty("facility")
    private String facilityName;

    @JsonProperty("distance")
    private Long   distanceTravelled;

    private Long   quantity;

    private String material;

    //Processing of sold goods

    @JsonProperty("facility2")
    private String goodsFacilityName;

    @JsonProperty("code2")
    private String goodsFacilityCode;

    @JsonProperty("byername2")
    private String goodsBuyerName;

    @JsonProperty("byerlocation2")
    private String goodsBuyerLocation;

    @JsonProperty("material2")
    private String goodsMaterial;

    @JsonProperty("quantity2")
    private Long   goodsQuantity;

    @JsonProperty("process")
    private String goodsProcessingPerformed;

    @JsonProperty("finalproduct")
    private String goodsFinalProduct;

//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "sg_select_transport_id", nullable = true)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","catalogueType"})

    @JsonProperty("transport")
    private String goodsSelectTransport;

//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "sg_select_vehicle_id", nullable = true)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","catalogueType"})

    @JsonProperty("vehicle")
    private String goodsSelectVehicle;

    //Use of Sold Products

    @JsonProperty("productname")
    private String soldProductName;

    @JsonProperty("usagetime")
    private String soldUsageTime;

   //End of life treatment of sold products

    @JsonProperty("productname2")
    private String lifeOfSoldProductName;

    @JsonProperty("disposal")
    private String lifeOfSoldUsageTime;

    //Downstream leased assets

    @JsonProperty("lease")
    private String leasePeriod;


    //Franchise

    @JsonProperty("namefranchise")
    private String franchiseName;

    @JsonProperty("location")
    private String franchiseLocation;

    @JsonProperty("franchiseperiod")
    private String franchisePeriod;

    //Investments

    @JsonProperty("investment")
    private String investmentType;

    @JsonProperty("location2")
    private String investmentLocation;
}
