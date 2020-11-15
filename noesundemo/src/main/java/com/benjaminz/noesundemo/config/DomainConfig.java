package com.benjaminz.noesundemo.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan(basePackages = {"com.benjaminz.noesundemo.domain"})
@EnableJpaRepositories(basePackages = {"com.benjaminz.noesundemo.repos"})
@EnableTransactionManagement
public class DomainConfig {
}
