package com.github.nschlechter.showlist.server.dal.repository;

import com.github.nschlechter.showlist.server.dal.entity.VenueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenueRepo extends JpaRepository<VenueEntity, String> {
    List<VenueEntity> findByName(String name);

    List<VenueEntity> findByNameAndCityAndStateAllIgnoreCase(String name, String city, String state);
}
