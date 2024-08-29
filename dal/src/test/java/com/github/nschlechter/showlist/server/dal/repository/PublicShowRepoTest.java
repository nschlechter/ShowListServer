package com.github.nschlechter.showlist.server.dal.repository;

import com.github.nschlechter.showlist.server.dal.TestConstantHelper;
import com.github.nschlechter.showlist.server.dal.TestDataConfig;
import com.github.nschlechter.showlist.server.dal.entity.ArtistEntity;
import com.github.nschlechter.showlist.server.dal.entity.PublicShowEntity;
import com.github.nschlechter.showlist.server.dal.entity.ShowArtistEntity;
import com.github.nschlechter.showlist.server.dal.entity.VenueEntity;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;
import java.util.UUID;

@Slf4j
@ContextConfiguration(classes = TestDataConfig.class)
@DataJpaTest
public class PublicShowRepoTest extends TestConstantHelper {

    @Autowired
    private PublicShowRepo repository;
    @Autowired private ArtistRepo artistRepo;
    @Autowired private VenueRepo venueRepo;

    @BeforeEach
    public void setup() {
        // ensure that the db is in a clean state before running each test method
        Assertions.assertEquals(0, repository.count(),
                "Database is not clean prior to running test method");
    }

    @Test
    public void testSaveAndGetWithoutNestedEntities() {
        PublicShowEntity publicShow = getPublicShowEntityWithoutNestedEntities();
        PublicShowEntity savedShow = repository.save(publicShow);
        assertEquals(savedShow, publicShow);
    }

    /**
     * In order to save a PublicShowEntity, the (if any) artists associated with
     * the show need to be persisted in the artist repository first, otherwise we
     * will get an exception.
     */
    @Test
    public void testSaveThrowsExceptionWhenArtistWasntSavedFirst() {
        // get dummy show entity
        PublicShowEntity show = getPublicShowEntityWithoutNestedEntities();

        // get dummy artist
        ArtistEntity artist = getArtist();
        // do not save to artist table
        //artistRepo.save(artist);

        // get artist <-> show entity mapping
        ShowArtistEntity artistEntity = getShowArtist(artist, show);

        // set the artists in the show object to be saved
        show.setArtists(Set.of(artistEntity));

        // assert that the db throws an exception because the artist wasn't found in the artist table
        Exception e = Assertions.assertThrows(JpaObjectRetrievalFailureException.class, () -> repository.save(show));
        Assertions.assertInstanceOf(EntityNotFoundException.class, e.getCause());
    }

    /**
     * In order to save a PublicShowEntity, the venue (if exists) associated with
     * the show needs to be persisted in the venue repository first, otherwise we
     * will get an exception.
     */
    @Test
    public void testSaveThrowsExceptionWhenVenueWasntSavedFirst() {
        // get essentially blank show entity
        PublicShowEntity show = getPublicShowEntityWithoutNestedEntities();
        show.setVenue(new VenueEntity("Venue Name"));

        // assert that the db throws an exception because the artist wasn't found in the artist table
        Exception e = Assertions.assertThrows(JpaObjectRetrievalFailureException.class, () -> repository.save(show));
        Assertions.assertInstanceOf(EntityNotFoundException.class, e.getCause());
    }

    @Test
    public void testSaveWhenNestedEntitiesExist() {
        // get dummy show entity
        PublicShowEntity show = getPublicShowEntityWithoutNestedEntities();

        // get dummy venue
        VenueEntity venueEntity = new VenueEntity("Venue Name");
        // add venue entity to its table
        venueRepo.save(venueEntity);
        // add this venue to the public show entity
        show.setVenue(venueEntity);

        // get dummy artist
        ArtistEntity artist = getArtist();
        // save to artist table
        artistRepo.save(artist);
        // get artist <-> show entity mapping
        ShowArtistEntity artistEntity = getShowArtist(artist, show);
        // set the artists in the show object to be saved
        show.setArtists(Set.of(artistEntity));

        PublicShowEntity savedShow = repository.save(show);
        assertEquals(show, savedShow);
    }

    private PublicShowEntity getPublicShowEntityWithoutNestedEntities() {
        String showId = UUID.randomUUID().toString();
        return new PublicShowEntity(showId, "Show Name", null, null, LocalDate.now(), LocalTime.now());
    }

    private void assertEquals(PublicShowEntity expected, PublicShowEntity actual) {
        Assertions.assertEquals(expected.getId(), actual.getId(), "Id field is not equal");
        Assertions.assertEquals(expected.getName(), actual.getName(), "Name field is not equal");
        Assertions.assertEquals(expected.getArtists(), actual.getArtists(), "Artists are not equal");
        Assertions.assertEquals(expected.getVenue(), actual.getVenue(), "Venue is not equal");
        Assertions.assertEquals(expected.getDate(), actual.getDate(), "Date is not equal");
        Assertions.assertEquals(expected.getTime(), actual.getTime(), "Time is not equal");
    }
}
