package com.github.nschlechter.showlist.server.dal.repository;

import com.github.nschlechter.showlist.server.dal.entity.UserShowEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserShowRepo extends JpaRepository<UserShowEntity, String> {
    Page<UserShowEntity> findAllByUserId(String userId, Pageable pageable);
}
