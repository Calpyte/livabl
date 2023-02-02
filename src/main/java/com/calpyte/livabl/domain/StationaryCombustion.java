package com.calpyte.livabl.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
public class StationaryCombustion extends AuditableBase{
    private String name;
    private String facilityCode;
    private String facilityName;
    private Double quantity;

    private Date combustionDate;

    @Transient
    private String combustionDateStr;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "fuel_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler","catalogueType"})
    private Catalogue fuel;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "type_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler","catalogueType"})
    private Catalogue type;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "source_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler","catalogueType"})
    private Catalogue source;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "unit_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler","catalogueType"})
    private Catalogue unit;
}
