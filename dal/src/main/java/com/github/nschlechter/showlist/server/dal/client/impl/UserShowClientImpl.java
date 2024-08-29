package com.github.nschlechter.showlist.server.dal.client.impl;

import com.github.nschlechter.showlist.server.dal.client.UserShowClient;
import com.github.nschlechter.showlist.server.dal.entity.UserShowEntity;
import com.github.nschlechter.showlist.server.dal.repository.UserShowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserShowClientImpl implements UserShowClient {

    @Autowired private UserShowRepo userShowRepo;

    @Override
    public UserShowEntity saveUserShow(UserShowEntity userShowEntity) {
        return userShowRepo.save(userShowEntity);
    }

    @Override
    public Page<UserShowEntity> getAllUserShows(UUID userId) {
        if(userId == null) {
            return Page.empty();
        }
        // TODO - fix/handle arbitrary page size
        return userShowRepo.findAllByUserId(userId.toString(), Pageable.ofSize(10));
    }
}
