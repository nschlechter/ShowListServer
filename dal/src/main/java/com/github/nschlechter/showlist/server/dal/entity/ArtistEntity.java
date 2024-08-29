package com.github.nschlechter.showlist.server.dal.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;
import java.util.UUID;

@Table(name = "artist")
@Entity
@Getter
@AllArgsConstructor
public class ArtistEntity {

    @Id
    private String id;
    private String name;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // lazy loading because we generally don't need this field
    private Set<ShowArtistEntity> shows;

    private ArtistEntity() {
        // do not use default constructor
    }

    public ArtistEntity(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }
}
