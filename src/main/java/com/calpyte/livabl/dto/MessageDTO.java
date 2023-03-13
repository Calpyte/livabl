package com.calpyte.livabl.dto;

import lombok.Data;

import java.util.List;

@Data
public class MessageDTO {

    private String fromId;

    private List<String> toId;

    private String subject;

    private String regarding;

    private List<String> listOfCc;
}
