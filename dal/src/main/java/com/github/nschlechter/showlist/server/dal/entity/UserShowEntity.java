package com.github.nschlechter.showlist.server.dal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Entity
@Builder
@Getter
@AllArgsConstructor
public class UserShowEntity {

    @Id
    private String id;

    private String userId;

    private String publicShowId;

    // TODO - add column max and min constraints (maybe use double instead of int?)
    private Integer rating;

    private String notes;

    private UserShowEntity() {
        // do not use default constructor
    }
}
