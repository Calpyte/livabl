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
public class FugitiveGases extends AuditableBase{

    @Temporal(TemporalType.DATE)

    @JsonProperty("date")
    private Date fugitiveGasDate;

    @Transient
    private String fugitiveGasDateStr;

    @JsonProperty("gases")
    private String purchasedGases;

    @JsonProperty("code")
    private String facilityCode;

    @JsonProperty("facility")
    private String facilityName;


//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "gas_type_id", nullable = true)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler","catalogueType"})
    @JsonProperty("fuel")
    private String gasType;

    @JsonProperty("quantity")
    private String amountOfGas;

    @JsonProperty("yesno")
    private String type;

    @JsonProperty("code2")
    private String fireCode;

    @JsonProperty("facility2")
    private String fireName;

    @JsonProperty("fire")
    private String fireSuppresant;

//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "gas_used_id", nullable = true)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler","catalogueType"})

    @JsonProperty("typegas")
    private String gasUsed;

    @JsonProperty("capacity")
    private String totalCapacityEquipment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fugitive_emission_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private FugitiveEmission fugitiveEmission;

}
