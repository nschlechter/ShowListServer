package com.github.nschlechter.showlist.server.dal.client.impl;

import ch.qos.logback.core.util.StringUtil;
import com.github.nschlechter.showlist.server.dal.client.VenueClient;
import com.github.nschlechter.showlist.server.dal.entity.VenueEntity;
import com.github.nschlechter.showlist.server.dal.repository.VenueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class VenueClientImpl implements VenueClient {

    @Autowired private VenueRepo venueRepo;

    @Override
    public VenueEntity saveVenue(VenueEntity venueEntity) {
        return venueRepo.save(venueEntity);
    }

    @Override
    public List<VenueEntity> getVenues() {
        return venueRepo.findAll();
    }

    @Override
    public Optional<VenueEntity> getVenue(UUID uuid) {
        if(uuid == null) {
            return Optional.empty();
        }
        return venueRepo.findById(uuid.toString());
    }

    @Override
    public List<VenueEntity> getVenuesByName(String name) {
        if(StringUtil.isNullOrEmpty(name)) {
            return new ArrayList<>();
        }
        return venueRepo.findByName(name);
    }

    @Override
    public List<VenueEntity> getVenues(String name, String city, String state) {
        // TODO null checks
        return venueRepo.findByNameAndCityAndStateAllIgnoreCase(name, city, state);
    }
}
