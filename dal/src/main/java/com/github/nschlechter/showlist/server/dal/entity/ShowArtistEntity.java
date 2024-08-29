package com.github.nschlechter.showlist.server.dal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Table(name = "show_artist")
@Entity
@Builder
@Getter
@AllArgsConstructor
public class ShowArtistEntity {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private ArtistEntity artist;

    @ManyToOne
    @JoinColumn(name = "show_id")
    private PublicShowEntity show;

    @Enumerated(EnumType.STRING)
    private ArtistShowType artistShowType;

    private ShowArtistEntity() {
        // do not use default constructor
    }
}
