package com.mkpits.trading.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
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

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
             entityManagerFactoryRef = "mySqlEntityManagerFactory",
             transactionManagerRef = "mySqlTransactionManager",
             basePackages = {
                     "com.mkpits.trading.mysql.repository"
             }
)
public class MySQLdbConfig {

    @Value("${spring.mysql.datasource.url}")
    private String dbURL;

    @Value("${spring.mysql.datasource.username}")
    private String username;

    @Value("${spring.mysql.datasource.password}")
    private String password;

    @Value("${spring.mysql.datasource.driverClassName}")
    private String driverClassName;

    // Create DataSource
    @Bean (name = "mySqlDataSource")
    @ConfigurationProperties(prefix = "spring.mysql.datasource")
    public DataSource dataSource (){

        return DataSourceBuilder.create()
                .driverClassName(driverClassName)
                .url(dbURL)
                .username(username)
                .password(password)
                .build();
    }

    // DataSource Injected to EntityManagerFactory
    @Bean(name = "mySqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mySqlEntityManagerFactory (EntityManagerFactoryBuilder builder,
                                                                             @Qualifier("mySqlDataSource") DataSource dataSource){

        return builder
                .dataSource(dataSource)
                .packages("com.mkpits.trading.mysql.model")
                .persistenceUnit("mysql")
                .build();
    }

    // EntityManagerFactory Injected to TransactionManager
    @Bean(name = "mySqlTransactionManager")
    public PlatformTransactionManager mySqlTransactionManager(@Qualifier("mySqlEntityManagerFactory")
                                                              EntityManagerFactory entityManagerFactory){

        return new JpaTransactionManager(entityManagerFactory);
    }

}
