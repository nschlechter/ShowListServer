package com.github.nschlechter.showlist.server.dal.repository;

import com.github.nschlechter.showlist.server.dal.TestDataConfig;
import com.github.nschlechter.showlist.server.dal.entity.ArtistEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@ContextConfiguration(classes = TestDataConfig.class)
@DataJpaTest
public class ArtistRepoTest {

    @Autowired private ArtistRepo artistRepo;

    @Test
    public void testFindByName() {
        artistRepo.save(new ArtistEntity("Flume"));
        List<ArtistEntity> flumeArtists = artistRepo.findByName("Flume");
        Assertions.assertEquals(1, flumeArtists.size());
        List<ArtistEntity> odeszaArtists = artistRepo.findByName("Odesza");
        Assertions.assertEquals(0, odeszaArtists.size());
    }
}
