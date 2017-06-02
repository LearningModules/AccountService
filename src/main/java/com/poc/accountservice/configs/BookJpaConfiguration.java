package com.poc.accountservice.configs;

import com.poc.accountservice.entity.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Refer - https://scattercode.co.uk/2016/01/05/multiple-databases-with-spring-boot-and-spring-data-jpa/
 */
//@Configuration
//@EnableJpaRepositories(entityManagerFactoryRef = "bookEntityManagerFactoryBean", transactionManagerRef = "customerTransactionManager")
public class BookJpaConfiguration {


    @Bean
    DataSource bookDataSource() {
        return new EmbeddedDatabaseBuilder().//
                setType(EmbeddedDatabaseType.HSQL).//
                setName("customers").//
                build();
    }

   @Bean
    LocalContainerEntityManagerFactoryBean bookEntityManagerFactory(){
       HibernateJpaVendorAdapter hibernateJpaVendorAdapter=new HibernateJpaVendorAdapter();
       hibernateJpaVendorAdapter.setGenerateDdl(true);
       hibernateJpaVendorAdapter.setShowSql(true);

       LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
       factoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);
       factoryBean.setDataSource(bookDataSource());
       factoryBean.setPackagesToScan(Book.class.getPackage().getName());
       return factoryBean;
   }

   @Bean
    PlatformTransactionManager customerTransactionManager()
   {
       return new JpaTransactionManager(bookEntityManagerFactory().getObject());
   }
}
