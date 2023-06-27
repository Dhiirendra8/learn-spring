package com.learn.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.cassandra.config.EnableCassandraAuditing;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication //(exclude = {DataSourceAutoConfiguration.class })
@EnableAutoConfiguration
@EnableCassandraRepositories
public class TestAPIApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestAPIApplication.class, args);
    }

}
