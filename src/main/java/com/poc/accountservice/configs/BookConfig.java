package com.poc.accountservice.configs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by reji on 02/06/17.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "bookEntityManagerFactory",
        transactionManagerRef = "bookTransactionManager",
        basePackages = { "com.poc.accountservice.entity" })

public class BookConfig {

    @Bean(name = "bookDataSource")
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource bookDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "bookEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean bookEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("bookDataSource") DataSource barDataSource) {
        return builder
                .dataSource(bookDataSource())
                .packages("com.poc.accountservice.entity")
                .persistenceUnit("book")
                .build();
    }

    @Bean(name = "bookTransactionManager")
    public PlatformTransactionManager bookTransactionManager(
            @Qualifier("bookEntityManagerFactory") EntityManagerFactory bookEntityManagerFactory) {
        return new JpaTransactionManager(bookEntityManagerFactory);
    }
}
