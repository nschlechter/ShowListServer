package com.github.nschlechter.showlist.server.dal.repository;

import com.github.nschlechter.showlist.server.dal.TestDataConfig;
import com.github.nschlechter.showlist.server.dal.entity.PublicShowEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;
import java.util.UUID;

@ContextConfiguration(classes = TestDataConfig.class)
@DataJpaTest
public class PublicShowRepoTest {

    @Autowired
    private PublicShowRepo repository;

    @BeforeEach
    public void setup() {
        // ensure that the db is in a clean state before running each test method
        Assertions.assertEquals(0, repository.count(), "Database is not clean prior to running test method");
    }

    @Test
    public void testSaveAndGet() {
        PublicShowEntity publicShow = getPublicShowEntity();
        PublicShowEntity savedShow = repository.save(publicShow);
        assertEquals(savedShow, publicShow);
    }

    private PublicShowEntity getPublicShowEntity() {
        return PublicShowEntity.builder().id(UUID.randomUUID().toString()).artistId(UUID.randomUUID().toString()).venueId(UUID.randomUUID().toString()).date(LocalDate.now()).build();
    }

    private void assertEquals(PublicShowEntity expected, PublicShowEntity actual) {
        Assertions.assertEquals(expected.getId(), actual.getId(), "Id field is not equal");
        Assertions.assertEquals(expected.getArtistId(), actual.getArtistId(), "Artist Id is not equal");
        Assertions.assertEquals(expected.getVenueId(), actual.getVenueId(), "Venue Id is not equal");
        // TODO - date conversions are not working as expected
        Assertions.assertEquals(expected.getDate(), actual.getDate(), "Date is not equal");
        Assertions.assertEquals(expected.getTime(), actual.getTime(), "Time is not equal");
    }
}
