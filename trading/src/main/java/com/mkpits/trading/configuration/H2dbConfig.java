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
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "h2EntityManagerFactory",
        transactionManagerRef = "h2TransactionManager",
        basePackages = {
                "com.mkpits.trading.h2db.repository"
        }
)
public class H2dbConfig {

    @Value("${spring.h2db.datasource.url}")
    private String dbURL;

    @Value("${spring.h2db.datasource.username}")
    private String username;

    @Value("${spring.h2db.datasource.password}")
    private String password;

    @Value("${spring.h2db.datasource.driverClassName}")
    private String driverClassName;


    // Create DataSource
//    @Primary
    @Bean(name = "h2DataSource")
    @ConfigurationProperties(prefix = "spring.h2db.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder.create()
                .url(dbURL)
                .driverClassName(driverClassName)
                .username(username)
                .password(password)
                .build();
    }

    // DataSource Injected to EntityManagerFactory
//    @Primary
    @Bean(name = "h2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean h2EntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                       @Qualifier("h2DataSource") DataSource dataSource){

        HashMap<String,Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto","create");
        properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");


        return builder.dataSource(dataSource)
                .properties(properties)
                .packages("com.mkpits.trading.h2db.model")
                .persistenceUnit("h2db")
                .build();
    }

    // EntityManagerFactory Injected to TransactionManager
//    @Primary
    @Bean(name = "h2TransactionManager")
    public PlatformTransactionManager transactionManager (@Qualifier("h2EntityManagerFactory")
                                                          EntityManagerFactory entityManagerFactory){

        return new JpaTransactionManager(entityManagerFactory);
    }
}


//// We are commenting @Primary here and give it to the MySQLConfig , We have to
//// provide @Primary to any one of them