package com.github.nschlechter.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

import java.util.UUID;

@Entity
@Getter
public class VenueEntity {

    @Id
    private String id;
    private String name;
    private String city;
    private String state;

    private VenueEntity() {
        // do not use default constructor
    }

    public VenueEntity(String id, String name, String city, String state) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.state = state;
    }

    public VenueEntity(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }
}
