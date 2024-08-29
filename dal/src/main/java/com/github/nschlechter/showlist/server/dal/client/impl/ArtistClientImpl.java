package com.github.nschlechter.showlist.server.dal.client.impl;

import ch.qos.logback.core.util.StringUtil;
import com.github.nschlechter.showlist.server.dal.client.ArtistClient;
import com.github.nschlechter.showlist.server.dal.entity.ArtistEntity;
import com.github.nschlechter.showlist.server.dal.repository.ArtistRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class ArtistClientImpl implements ArtistClient {

    @Autowired private ArtistRepo artistRepo;

    @Override
    public ArtistEntity saveArtist(ArtistEntity artistEntity) {
        log.info("Saving artist: {}", artistEntity);
        return artistRepo.save(artistEntity);
    }

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
