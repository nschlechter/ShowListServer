package com.github.nschlechter.showlist.server.dal.client;

import com.github.nschlechter.showlist.server.dal.TestConstantHelper;
import com.github.nschlechter.showlist.server.dal.TestDataConfig;
import com.github.nschlechter.showlist.server.dal.entity.ArtistEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = TestDataConfig.class)
@DataJpaTest
public class ArtistClientTest extends TestConstantHelper {

    @Autowired private ArtistClient artistClient;

    @Test
    public void testSaveAndResave() {
        ArtistEntity artistEntity = getArtist();
        artistClient.saveArtist(artistEntity);
        artistClient.saveArtist(artistEntity);
    }
}
