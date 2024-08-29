package com.github.nschlechter.showlist.server.dal;

import com.github.nschlechter.showlist.server.dal.entity.ArtistEntity;
import com.github.nschlechter.showlist.server.dal.entity.ArtistShowType;
import com.github.nschlechter.showlist.server.dal.entity.PublicShowEntity;
import com.github.nschlechter.showlist.server.dal.entity.ShowArtistEntity;

import java.util.HashSet;
import java.util.UUID;

public class TestConstantHelper {

    public static String DUMMY_USER = "dummyUser";
    public static String DUMMY_PASSWORD = "dummyPassword";

    // Artists
    public static String FLUME = "Flume";
    public static String ODESZA = "Odesza";

    // Venues
    public static String RED_ROCKS = "Red Rocks Ampitheater";
    public static String GORGE = "Gorge Ampitheater";

    public String getEmail(String username) {
        return username + "@domain.com";
    }

    public ArtistEntity getArtist() {
        return new ArtistEntity(UUID.randomUUID().toString(), FLUME, new HashSet<>());
    }

    public ShowArtistEntity getShowArtist(ArtistEntity artist, PublicShowEntity show) {
        return ShowArtistEntity.builder().id(UUID.randomUUID().toString()).artist(artist).show(show).artistShowType(ArtistShowType.HEADLINER).build();
    }
}
