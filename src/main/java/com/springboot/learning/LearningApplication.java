package com.springboot.learning;


import com.springboot.config.MySpringBootApplication;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;


@MySpringBootApplication
public class LearningApplication {


    private final JdbcTemplate jdbcTemplate;

    public LearningApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    void init(){
        jdbcTemplate.execute("create table if not exists learning(" +
        "studentName varchar(100) primary key," +
        "attendanceCount int)");
    }
    /*  @Bean
        ApplicationRunner applicationRunner(Environment env) {
            return (args) -> {
                String name = env.getProperty("my.name");
                System.out.println("my.name = "+name);
            };
        }*/
    public static void main(String[] args) {

        SpringApplication.run(LearningApplication.class, args);

    }


}
