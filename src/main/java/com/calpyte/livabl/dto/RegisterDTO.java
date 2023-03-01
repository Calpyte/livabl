package com.calpyte.livabl.dto;
import com.calpyte.livabl.domain.WebUser;
import lombok.Data;

@Data
public class RegisterDTO {
    private String id;
    private String cpassword;
    private String email;
    private String fname;
    private String password;
    private String temppass;
    private WebUser.UserType type;
}
