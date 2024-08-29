package com.github.nschlechter.showlist.server.dal.repository;

import com.github.nschlechter.showlist.server.dal.entity.PublicShowEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicShowRepo extends JpaRepository<PublicShowEntity, String> {
    // TODO - need to add Pageable parameter for these methods?
    Page<PublicShowEntity> findByArtists(String id, Pageable pageable);
}
