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
public class Upstream extends AuditableBase{

    @JsonProperty("date")
    private Date upstreamDate;

    @Transient
    private String upstreamDateStr;

    @JsonProperty("code")
    private String facilityCode;

    @JsonProperty("byername")
    private String buyerName;

    @JsonProperty("byerlocation")
    private String buyerLocation;

    @JsonProperty("facility")
    private String facilityName;

//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "select_transport_id", nullable = true)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","catalogueType"})

    @JsonProperty("transport")
    private String selectTransport;

//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "select_vehicle_id", nullable = true)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","catalogueType"})

    @JsonProperty("vehicle")
    private String selectVehicle;

    @JsonProperty("distance")
    private Long   distanceTravelled;

    @JsonProperty("quantity")
    private Long   quantity;

    @JsonProperty("material")
    private String material;

    //Waste Generated

    @JsonProperty("facility2")
    private String wasteFacilityName;

    @JsonProperty("code2")
    private String wasteFacilityCode;

    @JsonProperty("waste")
    private String wasteWasteType;

    @JsonProperty("dispose")
    private String wasteDispose;

    @JsonProperty("quantity2")
    private String wasteQuantity;

    //Business Travel
    @JsonProperty("facility3")
    private String businessFacilityName;

    @JsonProperty("code3")
    private String businessFacilityCode;

    @JsonProperty("employeecode")
    private String businessEmployeeCode;

    @JsonProperty("employeename")
    private String businessEmployeeName;

    @JsonProperty("from")
    private String businessFrom;

    @JsonProperty("to")
    private String businessTo;

    @JsonProperty("distance2")
    private Long   businessDistanceTravelled;

//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "bt_select_transport_id", nullable = true)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","catalogueType"})

    @JsonProperty("transport2")
    private String businessSelectTransport;

//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "bt_select_vehicle_id", nullable = true)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","catalogueType"})

    @JsonProperty("vehicle2")
    private String businessSelectVehicle;

    //Employee Commuting
    @JsonProperty("facility4")
    private String employeeFacilityName;

    @JsonProperty("code4")
    private String employeeFacilityCode;

    @JsonProperty("employeecode2")
    private String employeeEmployeeCode;

    @JsonProperty("employeename2")
    private String employeeEmployeeName;

    @JsonProperty("from2")
    private String employeeFrom;

    @JsonProperty("to2")
    private String employeeTo;

    @JsonProperty("distance3")
    private Long   employeeDistanceTravelled;
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "ec_select_transport_id", nullable = true)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","catalogueType"})

    @JsonProperty("transport3")
    private String employeeSelectTransport;
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "ec_select_vehicle_id", nullable = true)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","catalogueType"})

    @JsonProperty("vehicle3")
    private String employeeSelectVehicle;

    //Leased Assets
    @JsonProperty("asset")
    private String leasedType;

    @JsonProperty("period")
    private Long leasePeriod;


}
