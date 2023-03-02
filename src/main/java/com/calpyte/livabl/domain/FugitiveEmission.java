package com.calpyte.livabl.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class FugitiveEmission extends AuditableBase{

    @JsonProperty("code")
    private String facilityCode;

    @JsonProperty("facility")
    private String facilityName;

    @JsonProperty("f")
    private String refrigerant;

    @JsonProperty("i")
    private String totalRefrigerant;

    @JsonProperty("g")
    private String refCapacity;

//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "ref_type_id", nullable = true)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler","catalogueType"})
    @JsonProperty("refrigeration")
    private String refrigerationType;

    @JsonProperty("date")
    private Date fugitiveDate;

    @Transient
    private String fugitiveDateStr;

//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "refrigerant_type_id", nullable = true)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler","catalogueType"})
    @JsonProperty("refrigerant")
    private String refrigerantType;

    @JsonProperty("j")
    private String amountOfRefrigerant;

    @JsonProperty("h")
    private String refBought;

    private Double co2;

    @OneToMany(mappedBy = "fugitiveEmission")
    private List<FugitiveGases> gases;

    private String email;

}
