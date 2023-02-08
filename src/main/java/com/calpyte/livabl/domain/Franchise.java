package com.calpyte.livabl.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.Date;

@Data
@Entity
public class Franchise extends AuditableBase{
    private Date date;

    @Transient
    private String dateStr;

    private String userName;
    private String timeUsage;
    private String productName;
    private String disposal;
    private String assetType;
    private String leasePeriod;
    private String franchiseName;
    private String franchiseLocation;
    private String investmentType;
    private String location;
}
