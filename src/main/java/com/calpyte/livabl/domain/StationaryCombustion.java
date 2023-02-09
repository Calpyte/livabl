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
@Table
public class StationaryCombustion extends AuditableBase{

    @JsonProperty("code")
    private String facilityCode;

    @JsonProperty("facility")
    private String facilityName;

    @JsonProperty("quantity")
    private Double quantity;

    private Date combustionDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "unit_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler","catalogueType"})
    @JsonProperty("weight")
    private Catalogue unit;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "fuel_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler","catalogueType"})
    private Catalogue fuel;

    @JsonProperty("co2")
    private Double co2;

    @JsonProperty("ch4")
    private Double ch4;

    @JsonProperty("no2")
    private Double no2;

    @Transient
    private String date;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "source_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler","catalogueType"})
    @JsonProperty("type")
    private Catalogue source;

    @JsonProperty("email")
    private String email;

    @JsonProperty("person")
    private String person;

}
