package com.github.nschlechter.showlist.server.dal.repository;

import com.github.nschlechter.showlist.server.dal.entity.PublicShowEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface PublicShowRepo extends JpaRepository<PublicShowEntity, String> {
    // TODO - need to add Pageable parameter for these methods?
    Page<PublicShowEntity> findByArtistId(String id, Pageable pageable);

    Page<PublicShowEntity> findByArtistIdAndVenueId(String artistId, String venueId, Pageable pageable);

    Page<PublicShowEntity> findByArtistIdAndDate(String artistId, Date date, Pageable pageable);

    Page<PublicShowEntity> findByVenueIdAndDate(String venueId, Date date, Pageable pageable);
}
