package com.github.nschlechter.showlist.server.dal;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.github.nschlechter.showlist.server.dal.repository")
@EntityScan(basePackages="com.github.nschlechter.showlist.server.dal.entity")
public class TestDataConfig {
}
