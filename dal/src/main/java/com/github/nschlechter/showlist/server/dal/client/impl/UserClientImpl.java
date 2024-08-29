package com.github.nschlechter.showlist.server.dal.client.impl;

import ch.qos.logback.core.util.StringUtil;
import com.github.nschlechter.showlist.server.dal.client.UserClient;
import com.github.nschlechter.showlist.server.dal.entity.UserEntity;
import com.github.nschlechter.showlist.server.dal.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class UserClientImpl implements UserClient {

    @Autowired private UserRepo userRepo;

    @Override
    public UserEntity saveUser(UserEntity user) {
        return userRepo.save(user);
    }

    @Override
    public Optional<UserEntity> getUser(UUID uuid) {
        if(uuid == null) {
            return Optional.empty();
        }
        return userRepo.findById(uuid.toString());
    }

    @Override
    public Optional<UserEntity> getUserByUsername(String username) {
        if(StringUtil.isNullOrEmpty(username)) {
            return Optional.empty();
        }

        List<UserEntity> users = userRepo.findByUsernameIgnoreCase(username);
        if(users.size() > 1) {
            // TODO - throw exception
        }

        return users.stream().findFirst();
    }

    @Override
    public Optional<UserEntity> getUserByEmail(String email) {
        if(StringUtil.isNullOrEmpty(email)) {
            return Optional.empty();
        }

        List<UserEntity> users = userRepo.findByEmailIgnoreCase(email);
        if(users.size() > 1) {
            // TODO - throw exception
        }

        return users.stream().findFirst();
    }
}
