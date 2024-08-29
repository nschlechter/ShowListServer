package com.github.nschlechter.showlist.server.dal.client.impl;

import com.github.nschlechter.showlist.server.dal.client.PublicShowClient;
import com.github.nschlechter.showlist.server.dal.entity.PublicShowEntity;
import com.github.nschlechter.showlist.server.dal.repository.PublicShowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PublicShowClientImpl implements PublicShowClient {

    @Autowired private PublicShowRepo publicShowRepo;

    @Override
    public PublicShowEntity savePublicShow(PublicShowEntity publicShow) {
        // TODO - error handling if show exists already
        return publicShowRepo.save(publicShow);
    }

    @Override
    public Page<PublicShowEntity> getAllShows() {
        // TODO - fix arbitrary page size.
        return publicShowRepo.findAll(Pageable.ofSize(5));
    }

    @Override
    public Page<PublicShowEntity> getAllShowsForArtist(UUID artistUuid) {
        if(artistUuid == null) {
            return Page.empty();
        }
        // TODO - fix arbitrary page size
        return publicShowRepo.findByArtists(artistUuid.toString(), Pageable.ofSize(10));
    }
}
