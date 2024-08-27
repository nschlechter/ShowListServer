package com.github.nschlechter.showlist.server.dal.client;

import com.github.nschlechter.showlist.server.dal.entity.UserEntity;

import java.util.Optional;
import java.util.UUID;

public interface UserClient {

    /**
     * Retrieve, if exists, the user with the given uuid.
     * @param uuid non-null id.
     * @return user entity, if exists.
     */
    Optional<UserEntity> getUser(UUID uuid);

    /**
     * Get, if exists, the user with the given unique username.
     * @param username not-empty, unique username.
     * @return user entity, if exists.
     */
    Optional<UserEntity> getUserByUsername(String username);

    /**
     * Get, if exists, the user with the given unique email address.
     * @param email not-empty, unique user email address.
     * @return user entity, if exists.
     */
    Optional<UserEntity> getUserByEmail(String email);
}
