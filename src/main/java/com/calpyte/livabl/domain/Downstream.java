package com.calpyte.livabl.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Downstream extends AuditableBase{
    private Date date;

    @Transient
    private String dateStr;

    private String facilityCode;
    private String buyerName;
    private String buyerLocation;
    private String facilityName;
    private Long   distanceTravelled;
    private Long   quantity;
    private String material;

    //Processing of sold goods
    private String sgFacilityName;
    private String sgFacilityCode;
    private String sgBuyerName;
    private String sgBuyerLocation;
    private String sgMaterial;
    private Long   sgQuantity;
    private String sgProcessingPerformed;
    private String sgFinalProduct;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "sg_select_transport_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","catalogueType"})
    private Catalogue sgSelectTransport;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "sg_select_vehicle_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","catalogueType"})
    private Catalogue sgSelectVehicle;


    //Use of Sold Products
    private String spProductName;
    private String spUsageTime;

   //End of life treatment of sold products
    private String soldProductName;
    private String soldUsageTime;

    //Downstream leased assets
    private String leasePeriod;


    //Franchise
    private String franchiseName;
    private String franchiseLocation;
    private String franchisePeriod;

    //Investments
    private String investmentType;
    private String investmentLocation;
}
