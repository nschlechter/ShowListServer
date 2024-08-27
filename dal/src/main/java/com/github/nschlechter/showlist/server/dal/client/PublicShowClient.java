package com.github.nschlechter.showlist.server.dal.client;

import com.github.nschlechter.showlist.server.dal.entity.PublicShowEntity;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface PublicShowClient {

    /**
     * Save a new public show to the database.
     *
     * @param publicShow new entity to be saved to db.
     * @return public show entity that was persisted.
     */
    PublicShowEntity savePublicShow(PublicShowEntity publicShow);

    /**
     * Get all public shows in the db.
     *
     * @return page of public show entities.
     */
    Page<PublicShowEntity> getAllShows();

    /**
     * Get all public shows in the db for a given artist id.
     *
     * @param artistUuid non-null artist id.
     * @return page of all shows in the db that have the associated artist id.
     */
    Page<PublicShowEntity> getAllShowsForArtist(UUID artistUuid);
}
