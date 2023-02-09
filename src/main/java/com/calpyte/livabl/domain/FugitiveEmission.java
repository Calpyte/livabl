package com.calpyte.livabl.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class FugitiveEmission extends AuditableBase{
    private String facilityCode;
    private String facilityName;
    private Double refrigerant;
    private Double totalRefrigerant;
    private Double refCapacity;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "ref_type_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler","catalogueType"})
    private Catalogue refType;

    private Date fugitiveDate;

    @Transient
    private String fugitiveDateStr;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "refregerant_type_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler","catalogueType"})
    private Catalogue refregerantType;

    private Double amountRecovered;
    private Double refBought;

}
