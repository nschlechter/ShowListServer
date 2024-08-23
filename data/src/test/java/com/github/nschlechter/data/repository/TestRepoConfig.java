package com.github.nschlechter.data.repository;

import com.github.nschlechter.data.entity.VenueEntity;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.github.nschlechter.data.repository")
@EntityScan(basePackages="com.github.nschlechter.data.entity")
public class TestRepoConfig {
}
