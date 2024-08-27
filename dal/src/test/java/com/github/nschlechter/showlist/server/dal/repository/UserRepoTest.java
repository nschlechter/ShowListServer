package com.github.nschlechter.showlist.server.dal.repository;

import com.github.nschlechter.showlist.server.dal.TestConstantHelper;
import com.github.nschlechter.showlist.server.dal.TestDataConfig;
import com.github.nschlechter.showlist.server.dal.entity.UserEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ContextConfiguration(classes = TestDataConfig.class)
@DataJpaTest
public class UserRepoTest extends TestConstantHelper {

    private static String DUMMY_USER = "testUser";
    private static String DUMMY_PASSWORD = "password";

    @Autowired private UserRepo repository;

    @BeforeEach
    public void setup() {
        // ensure that the db is in a clean state before running each test method
        Assertions.assertEquals(0, repository.count(), "Database is not clean prior to running test method");
    }

    @Test
    public void testSaveAndGet() {
        UserEntity user = getUser(DUMMY_USER);
        UserEntity savedUser = repository.save(user);
        assertEquals(user, savedUser);

        Optional<UserEntity> retrievedUser = repository.findById(user.getId());
        Assertions.assertTrue(retrievedUser.isPresent());
        assertEquals(user, retrievedUser.get());
    }

    @Test
    public void testGetByUsernameIgnoreCase() {
        UserEntity user = getUser(DUMMY_USER);
        UserEntity savedUser = repository.save(user);
        assertEquals(user, savedUser);

        List<UserEntity> users = repository.findByUsernameIgnoreCase(DUMMY_USER.toUpperCase());
        Assertions.assertEquals(1, users.size());
        assertEquals(user, users.iterator().next());
    }

    @Test
    public void testGetByEmailIgnoreCase() {
        UserEntity user = getUser(DUMMY_USER);
        UserEntity savedUser = repository.save(user);
        assertEquals(user, savedUser);

        List<UserEntity> users = repository.findByEmailIgnoreCase(user.getEmail().toUpperCase());
        Assertions.assertEquals(1, users.size());
        assertEquals(user, users.iterator().next());
    }

    private UserEntity getUser(String username) {
        String email = getEmail(username);
        return UserEntity.builder().id(UUID.randomUUID().toString()).username(username).email(email).password(DUMMY_PASSWORD).build();
    }

    private void assertEquals(UserEntity expected, UserEntity actual) {
        Assertions.assertEquals(expected.getId(), actual.getId(), "Id field does not match");
        Assertions.assertEquals(expected.getUsername(), actual.getUsername(), "Username does not match");
        Assertions.assertEquals(expected.getEmail(), actual.getEmail(), "Email does not match");
        Assertions.assertEquals(expected.getPassword(), actual.getPassword(), "Password does not match");
    }
}
