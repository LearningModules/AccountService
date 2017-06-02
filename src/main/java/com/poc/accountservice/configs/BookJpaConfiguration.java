package com.poc.accountservice.configs;

/**
 * Refer - https://scattercode.co.uk/2016/01/05/multiple-databases-with-spring-boot-and-spring-data-jpa/
 */
//@Configuration
//@EnableJpaRepositories(entityManagerFactoryRef = "bookEntityManagerFactoryBean", transactionManagerRef = "customerTransactionManager")
public class BookJpaConfiguration {


   /* @Bean
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
   }*/
}
