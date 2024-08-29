package com.github.nschlechter.showlist.server.dal.repository;

import com.github.nschlechter.showlist.server.dal.TestConstantHelper;
import com.github.nschlechter.showlist.server.dal.TestDataConfig;
import com.github.nschlechter.showlist.server.dal.entity.PublicShowEntity;
import com.github.nschlechter.showlist.server.dal.entity.VenueEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.UUID;

@ContextConfiguration(classes = TestDataConfig.class)
@DataJpaTest
public class PublicShowRepoTest extends TestConstantHelper {

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
        VenueEntity v = new VenueEntity("venuetest");
        String showId = UUID.randomUUID().toString();
        PublicShowEntity show = new PublicShowEntity(showId, null, null, null, null);
        //ShowArtistEntity artistEntity = getShowArtist(getArtist(), show);
        //show.setArtists(Set.of(artistEntity));
        return show;
    }

    private void assertEquals(PublicShowEntity expected, PublicShowEntity actual) {
        Assertions.assertEquals(expected.getId(), actual.getId(), "Id field is not equal");
        Assertions.assertEquals(expected.getArtists(), actual.getArtists(), "Artist Id is not equal");
        Assertions.assertEquals(expected.getVenue(), actual.getVenue(), "Venue Id is not equal");
        Assertions.assertEquals(expected.getDate(), actual.getDate(), "Date is not equal");
        Assertions.assertEquals(expected.getTime(), actual.getTime(), "Time is not equal");
    }
}
