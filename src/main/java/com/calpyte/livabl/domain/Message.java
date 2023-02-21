package com.calpyte.livabl.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Table
@Entity
@Where(clause = "is_deleted = false")
public class Message extends AuditableBase{

    @JsonProperty("from")
    private String fromId;

    @JsonProperty("to")
    private String toId;

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("text")
    @Column(columnDefinition = "text")
    private String body;
}
