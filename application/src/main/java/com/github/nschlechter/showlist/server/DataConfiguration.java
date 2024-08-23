package com.github.nschlechter.showlist.server;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.github.nschlechter.showlist.server.dal.repository")
@EntityScan(basePackages="com.github.nschlechter.showlist.server.dal.entity")
@EnableTransactionManagement
public class DataConfiguration {

    // TODO
}
