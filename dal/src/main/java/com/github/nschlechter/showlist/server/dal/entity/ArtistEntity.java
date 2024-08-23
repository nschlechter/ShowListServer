package com.github.nschlechter.showlist.server.dal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Entity
@Getter
@AllArgsConstructor
public class ArtistEntity {

    @Id
    private String id;
    private String name;

    private ArtistEntity() {
        // do not use default constructor
    }

    public ArtistEntity(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }
}
