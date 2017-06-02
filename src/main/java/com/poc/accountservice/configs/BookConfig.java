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
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Refer - https://scattercode.co.uk/2016/01/05/multiple-databases-with-spring-boot-and-spring-data-jpa/
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager",
        basePackages = { "com.poc.accountservice.entity" })

public class BookConfig {

    @Bean(name = "bookDataSource")
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource bookDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean bookEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("bookDataSource") DataSource bookDataSource) {
        return builder
                .dataSource(bookDataSource())
                .packages("com.poc.accountservice.entity")
                .persistenceUnit("book")
                .build();
    }


    /*@Bean(name = "bookEntityManagerFactory")
    LocalContainerEntityManagerFactoryBean bookEntityManagerFactory(){
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter=new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        hibernateJpaVendorAdapter.setShowSql(true);

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);
        factoryBean.setDataSource(bookDataSource());
        factoryBean.setPackagesToScan(Book.class.getPackage().getName());
        return factoryBean;
    }*/

    @Bean(name = "transactionManager")
    public PlatformTransactionManager bookTransactionManager(
            @Qualifier("entityManagerFactory") EntityManagerFactory bookEntityManagerFactory) {
        return new JpaTransactionManager(bookEntityManagerFactory);
    }
}
