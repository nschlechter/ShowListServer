package com.github.nschlechter.showlist.server.dal.client;

import com.github.nschlechter.showlist.server.dal.entity.VenueEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VenueClient {

    /**
     * Save the venue to the db. This will update if the venue already exists.
     *
     * @param venueEntity new venue to be saved.
     * @return venue entity successfully saved in db.
     */
    VenueEntity saveVenue(VenueEntity venueEntity);

    /**
     * Get all venues in the db.
     * @return list of venues.
     */
    List<VenueEntity> getVenues();

    /**
     * Get venue entity by id.
     * @param uuid uuid
     * @return venue with given id.
     */
    Optional<VenueEntity> getVenue(UUID uuid);

    /**
     * Get all venues with the given venue name.
     * @param name of the venue.
     * @return list of venues in the db that have that name (case insensitive).
     */
    List<VenueEntity> getVenuesByName(String name);

    /**
     * Get all venues that match the given filter params (nulls are allowed).
     * @param name of the venue (case insensitive)
     * @param city of the venue (case insensitive)
     * @param state of the venue (case insensitive)
     * @return venues that have the given criteria.
     */
    List<VenueEntity> getVenues(String name, String city, String state);
}
