package com.calpyte.livabl.dto;

import lombok.Data;

@Data
public class ResponseTokenDTO {
    private String email;
    private String token;
    private String fname;
    private int type;
}
