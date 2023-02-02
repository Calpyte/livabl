package com.calpyte.livabl.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class MobileCombustion extends AuditableBase{
    private String name;
    private String facilityName;
    private String facilityCode;
    private Double quantity;

    private Double weight;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "transport_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","catalogueType"})
    private Catalogue transport;

    private Date mblDate;

    @Transient
    private String mblDateStr;

    private String category;
    private String subCategory;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "input_type_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler","catalogueType"})
    private Catalogue inputType;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "category_input_id", nullable = true)
    @OnDelete(action =  OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler","catalogueType"})
    private Catalogue categoryInput;
}
