package com.github.nschlechter.showlist.server.dal.repository;

import com.github.nschlechter.showlist.server.dal.entity.ArtistEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepo extends CrudRepository<ArtistEntity, String> {
    List<ArtistEntity> findByName(String name);
}
