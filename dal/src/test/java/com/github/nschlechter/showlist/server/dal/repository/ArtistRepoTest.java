package com.github.nschlechter.showlist.server.dal.repository;

import com.github.nschlechter.showlist.server.dal.TestDataConfig;
import com.github.nschlechter.showlist.server.dal.entity.ArtistEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@ContextConfiguration(classes = TestDataConfig.class)
@DataJpaTest
public class ArtistRepoTest {

    @Autowired private ArtistRepo repository;

    @BeforeEach
    public void setup() {
        // ensure that the db is in a clean state before running each test method
        Assertions.assertEquals(0, repository.count(), "Database is not clean prior to running test method");
    }

    @Test
    public void testFindByName() {
        repository.save(new ArtistEntity("Flume"));
        List<ArtistEntity> flumeArtists = repository.findByName("Flume");
        Assertions.assertEquals(1, flumeArtists.size());
        List<ArtistEntity> odeszaArtists = repository.findByName("Odesza");
        Assertions.assertEquals(0, odeszaArtists.size());
    }
}
