package com.github.nschlechter.data.repository;

import com.github.nschlechter.data.entity.VenueEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepo extends CrudRepository<VenueEntity, String> {}
