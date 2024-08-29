package com.github.nschlechter.showlist.server.dal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Table(name = "venue")
@Entity
@Getter
@AllArgsConstructor
public class VenueEntity {

    @Id
    private String id;
    private String name;
    private String city;
    private String state;

    private VenueEntity() {
        // do not use default constructor
    }

    public VenueEntity(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }
}
