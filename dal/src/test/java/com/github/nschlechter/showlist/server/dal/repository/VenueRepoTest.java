package com.github.nschlechter.showlist.server.dal.repository;

import com.github.nschlechter.showlist.server.dal.TestDataConfig;
import com.github.nschlechter.showlist.server.dal.entity.VenueEntity;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@ContextConfiguration(classes = TestDataConfig.class)
@DataJpaTest
public class VenueRepoTest {

    @Autowired
    private VenueRepo userRepository;

    @Test
    public void whenCalledSave_thenCorrectNumberOfUsers() {
        userRepository.save(new VenueEntity("Red Rocks"));
        List<VenueEntity> users = (List<VenueEntity>) userRepository.findAll();

        Assert.assertEquals(1, users.size());
    }
}
