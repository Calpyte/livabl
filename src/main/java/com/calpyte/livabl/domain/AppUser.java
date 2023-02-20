package com.calpyte.livabl.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "app_user")
public class AppUser extends AuditableBase{
    private String cpassword;
    private String email;
    private String fname;
    private String password;
    private String temppass;
}
