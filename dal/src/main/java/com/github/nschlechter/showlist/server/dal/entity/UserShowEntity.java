package com.github.nschlechter.showlist.server.dal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class UserShowEntity {

    @Id
    private String id;

    private String userId;

    private String publicShowId;

    private Integer rating;

    private String notes;

    private UserShowEntity() {
        // do not use default constructor
    }
}
