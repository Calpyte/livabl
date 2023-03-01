package com.calpyte.livabl.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Table(name = "web_user")
@Entity
@Where(clause = "is_deleted = false")
public class WebUser extends  AuditableBase{
    public  enum UserType{ CLIENT, SUBUSER, ADMIN }

    private String cpassword;
    private String email;
    private String fname;
    private String password;
    private String temppass;
    private String token;

    @JsonIgnore
    private UserType type;
}
