package com.calpyte.livabl.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Upstream extends AuditableBase{
    private Date date;

    @Transient
    private String dateStr;

    private String facilityCode;
    private String buyerName;
    private String buyerLocation;
    private String facilityName;

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

    private Long   distanceTravelled;
    private Long   quantity;
    private String material;

    //Waste Generated
    private String wsFacilityName;
    private String wsFacilityCode;
    private String wsWasteType;
    private String wsDispose;
    private String wsQuantity;

    //Business Travel
    private String btFacilityName;
    private String btFacilityCode;
    private String btEmployeeCode;
    private String btEmployeeName;
    private String btFrom;
    private String btTo;
    private Long   btDistanceTravelled;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "bt_select_transport_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","catalogueType"})
    private Catalogue btSelectTransport;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "bt_select_vehicle_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","catalogueType"})
    private Catalogue btSelectVehicle;

    //Employee Commuting
    private String ecFacilityName;
    private String ecFacilityCode;
    private String ecEmployeeCode;
    private String ecEmployeeName;
    private String ecFrom;
    private String ecTo;
    private Long   ecDistanceTravelled;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "ec_select_transport_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","catalogueType"})
    private Catalogue ecSelectTransport;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "ec_select_vehicle_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","catalogueType"})
    private Catalogue ecSelectVehicle;

    //Leased Assets
    private String leasedType;
    private Long leasePeriod;


}
