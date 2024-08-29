package com.github.nschlechter.showlist.server.dal.client;

import com.github.nschlechter.showlist.server.dal.entity.ArtistEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ArtistClient {

    ArtistEntity saveArtist(ArtistEntity artistEntity);

    List<ArtistEntity> getAllArtists();

    Optional<ArtistEntity> getArtist(UUID uuid);

    List<ArtistEntity> getArtistsByName(String name);
}
