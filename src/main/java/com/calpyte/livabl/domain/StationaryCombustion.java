package com.calpyte.livabl.domain;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
public class StationaryCombustion extends AuditableBase{

    private String name;

    @JsonProperty("code")
    private String facilityCode;

    @JsonProperty("facility")
    private String facilityName;

    private Double quantity;

    @JsonProperty("date")
    private Date combustionDate;

    @Transient
    private String combustionDateStr;

//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "fuel_id", nullable = true)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler","catalogueType"})
    private String fuel;

//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "type_id", nullable = true)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler","catalogueType"})
    private String type;

//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "source_id", nullable = true)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler","catalogueType"})
    private String source;

//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "unit_id", nullable = true)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler","catalogueType"})
    @JsonProperty("weight")
    private String unit;

    private Double ch4;
    private Double co2;
    private Double no2;

    private String email;

}
