package com.nikita.hohunskyi.application.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.nikita.hohunskyi.persistence")
@EntityScan(basePackages = "com.nikita.hohunskyi.domain")
@ComponentScan(basePackages = "com.nikita.hohunskyi.persistence")
public class PersistenceConfig {

}