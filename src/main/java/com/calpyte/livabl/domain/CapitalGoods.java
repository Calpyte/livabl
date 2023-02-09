package com.calpyte.livabl.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class CapitalGoods extends AuditableBase{
    private Date Date;

    @Transient
    private String dateStr;

    private String facilityCode;
    private String facilityName;
    private String buyerName;
    private String buyerLocation;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "select_transport_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","catalogueType"})
    private Catalogue selectTransport;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "select_vehicle_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","catalogueType"})
    private Catalogue selectVehicle;

    private Double disTravelled;
    private String matPurchased;
    private String quantity;

    private String vFacilityName;
    private String vFacilityCode;
    private Double vDisTravelled;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "v_select_transport", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","catalogueType"})
    private Catalogue vSelectTransport;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "v_select_vehicle", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","catalogueType"})
    private Catalogue vSelectType;

    private String bFacilityName;
    private String bFacilityCode;
    private Double buildingSize;
    private String bLocation;
    private String energy;
}
