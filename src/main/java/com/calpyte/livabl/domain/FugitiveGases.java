package com.calpyte.livabl.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class FugitiveGases extends AuditableBase{

    @Temporal(TemporalType.DATE)
    private Date fugitiveGasDate;

    @Transient
    private String fugitiveGasDateStr;

    private String purchasedGases;
    private String facilityCode;
    private String facilityName;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "gas_type_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler","catalogueType"})
    private Catalogue gasType;

    private Integer amountOfGas;

    private boolean type;
    private String fireCode;
    private String fireName;
    private Integer fireSuppresant;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "gas_used_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler","catalogueType"})
    private Catalogue gasUsed;

    private Integer totalCapacityEquipment;

}
