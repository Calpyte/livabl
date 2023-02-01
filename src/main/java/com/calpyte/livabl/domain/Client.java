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

    public enum Active{YES,NO}

    @JsonProperty("email")
    private String email;

    @JsonProperty("pass")
    private String pass;

    @JsonProperty("active")
    private Active active;

    @JsonProperty("eemail")
    private String emailId;

}
