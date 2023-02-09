package com.calpyte.livabl.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class ProcessEmissions extends AuditableBase{
    private String name;
    private String facilityName;
    private String facilityCode;
    private Double quantity;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "gas_type_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","catalogueType"})
    private Catalogue gasType;

    private Date processDate;

    @Transient
    private String processDateStr;
}
