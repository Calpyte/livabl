package com.calpyte.livabl.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.Date;

@Data
@Entity
public class MobileCombustion extends AuditableBase{
    private String name;

    @JsonProperty("facility")
    private String facilityName;

    @JsonProperty("code")
    private String facilityCode;

    private Double quantity;
    private String fuel;
    private Double weight;

    @JsonProperty("mode")
    private String transport;

    @JsonProperty("date")
    private Date mobileDate;

    @Transient
    private String mobileDateStr;

    private String category;

    @JsonProperty("subcat")
    private String subCategory;

//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "input_distance_id", nullable = true)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler","catalogueType"})
    @JsonProperty("literdistance")
    private String inputDistance;

//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "category_input_id", nullable = true)
//    @OnDelete(action =  OnDeleteAction.CASCADE)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler","catalogueType"})
    private String air;

    @JsonProperty("nonroad")
    private String nonRoad;

    private String road;
    private String air2;
    private String water;
    private String rail;

    private Double ch4;
    private Double co2;
    private Double no2;

    private String email;
}
