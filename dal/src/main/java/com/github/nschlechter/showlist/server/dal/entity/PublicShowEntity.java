package com.github.nschlechter.showlist.server.dal.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;


@Table(name = "public_show")
@Entity
@Builder
@Data
@AllArgsConstructor
public class PublicShowEntity {

    @Id
    private String id;

    private String name;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL, fetch = FetchType.EAGER) // eager loading to avoid N+1 query problem
    private Set<ShowArtistEntity> artists;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "venue_id")
    private VenueEntity venue;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(updatable = false)
    private LocalDate date;

    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime time;

    private PublicShowEntity() {
        // do not use default constructor
    }
}
