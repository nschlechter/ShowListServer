package com.github.nschlechter.showlist.server.dal.client;

import com.github.nschlechter.showlist.server.dal.entity.UserShowEntity;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface UserShowClient {

    /**
     * Save a new user show experience to the db.
     *
     * @param userShowEntity a given user's show experience entity.
     * @return the user show entity saved in the db.
     */
    UserShowEntity saveUserShow(UserShowEntity userShowEntity);

    /**
     * Get all personal show data for all of a given user's shows.
     * @param userId id of the current session user.
     * @return page of all user shows.
     */
    Page<UserShowEntity> getAllUserShows(UUID userId);
}
