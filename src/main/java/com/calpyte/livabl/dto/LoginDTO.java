package com.calpyte.livabl.dto;

import lombok.Data;

@Data
public class LoginDTO {
    private String email;
    private String password;
    private int type;
}
