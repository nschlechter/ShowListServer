package com.github.nschlechter.showlist.server.dal.client.impl;

import ch.qos.logback.core.util.StringUtil;
import com.github.nschlechter.showlist.server.dal.client.ArtistClient;
import com.github.nschlechter.showlist.server.dal.entity.ArtistEntity;
import com.github.nschlechter.showlist.server.dal.repository.ArtistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ArtistClientImpl implements ArtistClient {

    @Autowired private ArtistRepo artistRepo;

    @Override
    public List<ArtistEntity> getAllArtists() {
        return artistRepo.findAll();
    }

    @Override
    public Optional<ArtistEntity> getArtist(UUID uuid) {
        if(uuid == null) {
            return Optional.empty();
        }
        return artistRepo.findById(uuid.toString());
    }

    @Override
    public List<ArtistEntity> getArtistsByName(String name) {
        if(StringUtil.isNullOrEmpty(name)) {
            return new ArrayList<>();
        }
        return artistRepo.findByName(name);
    }
}
