package com.github.nschlechter.showlist.server.dal.repository;

import com.github.nschlechter.showlist.server.dal.TestDataConfig;
import com.github.nschlechter.showlist.server.dal.entity.UserShowEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.UUID;

@ContextConfiguration(classes = TestDataConfig.class)
@DataJpaTest
public class UserShowRepoTest {

    @Autowired
    private UserShowRepo repository;

    @BeforeEach
    public void setup() {
        // ensure that the db is in a clean state before running each test method
        Assertions.assertEquals(0, repository.count(), "Database is not clean prior to running test method");
    }

    @Test
    public void testSaveAndGet() {
        UserShowEntity userShow = getUserShow();
        UserShowEntity savedShow = repository.save(userShow);
        assertEquals(savedShow, userShow);
    }

    private UserShowEntity getUserShow() {
        return UserShowEntity.builder().id(UUID.randomUUID().toString()).userId(UUID.randomUUID().toString()).show(null).rating(4).build();
    }

    private void assertEquals(UserShowEntity expected, UserShowEntity actual) {
        Assertions.assertEquals(expected.getId(), actual.getId(), "Id is not equal");
        Assertions.assertEquals(expected.getUserId(), actual.getUserId(), "User Id is not equal");
        Assertions.assertEquals(expected.getShow(), actual.getShow(), "Public show Id is not equal");
        Assertions.assertEquals(expected.getRating(), actual.getRating());
        Assertions.assertEquals(expected.getNotes(), actual.getNotes());
    }
}
