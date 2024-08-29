package com.github.nschlechter.showlist.server.dal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Table(name = "user_show")
@Entity
@Builder
@Data
@AllArgsConstructor
public class UserShowEntity {

    @Id
    private String id;

    private String userId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "public_show_id")
    private PublicShowEntity show;

    // TODO - add column max and min constraints (maybe use double instead of int?)
    private Integer rating;

    private String notes;

    private UserShowEntity() {
        // do not use default constructor
    }
}
