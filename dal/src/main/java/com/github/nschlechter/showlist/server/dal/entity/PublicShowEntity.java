package com.github.nschlechter.showlist.server.dal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@AllArgsConstructor
public class PublicShowEntity {

    @Id
    private String id;

    private String artistId;

    private String venueId;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date date;

    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date time;

    private PublicShowEntity() {
        // do not use default constructor
    }
}
