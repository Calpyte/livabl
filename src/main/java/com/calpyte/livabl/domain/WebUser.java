package com.calpyte.livabl.domain;

import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
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
    private Integer type;

    @Column(columnDefinition = "boolean default false")
    private Boolean isActive;

}
