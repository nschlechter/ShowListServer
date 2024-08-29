package com.github.nschlechter.showlist.server.dal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Table(name = "users")
@Entity
@Data
@Builder
@AllArgsConstructor
public class UserEntity {

    @Id
    private String id;
    @Column(unique=true)
    private String username;
    @Column(unique=true)
    private String email;
    private String password;

    private UserEntity() {
        // do not use default constructor
    }
}
