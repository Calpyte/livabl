package com.calpyte.livabl.dto;

import lombok.Data;

@Data
public class CatalogueDTO {
    private String id;
    private String name;
    private BasicDTO catalogueType;
}
