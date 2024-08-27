package com.github.nschlechter.showlist.server.dal.repository;

import com.github.nschlechter.showlist.server.dal.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<UserEntity, String> {
    List<UserEntity> findByUsernameIgnoreCase(String username);
    List<UserEntity> findByEmailIgnoreCase(String email);
}
