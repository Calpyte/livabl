package com.calpyte.livabl.domain;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "client")
@Where(clause = "is_deleted = false")
public class Client extends  AuditableBase{

    public enum Active{YES,NO,REMOVE}

    @JsonProperty("email")
    private String email;

    @JsonProperty("pass")
    private String pass;

    @JsonProperty("active")
    private String active;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("pocnumber")
    private String pocNumber;

    @JsonProperty("pocname")
    private String pocName;

    @JsonProperty("noofemployees")
    private String noOfEmployees;

    @JsonProperty("website")
    private String website;

    @JsonProperty("address")
    private String address;

    @JsonProperty("description")
    private String description;

}
