package com.github.nschlechter.showlist.server.dal.client;

import com.github.nschlechter.showlist.server.dal.entity.UserShowEntity;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface UserShowClient {

    /**
     * Get all personal show data for all of a given user's shows.
     * @param userId id of the current session user.
     * @return page of all user shows.
     */
    Page<UserShowEntity> getAllUserShows(UUID userId);
}
