package com.calpyte.livabl.dto;

import lombok.Data;

@Data
public class RegisterDTO {
    private String id;
    private String cpassword;
    private String email;
    private String fname;
    private String password;
    private String temppass;
    private Boolean isActive;
    private int type;
}
