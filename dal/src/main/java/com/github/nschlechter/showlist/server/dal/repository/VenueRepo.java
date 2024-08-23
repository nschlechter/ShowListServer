package com.github.nschlechter.showlist.server.dal.repository;

import com.github.nschlechter.showlist.server.dal.entity.VenueEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepo extends CrudRepository<VenueEntity, String> {}
