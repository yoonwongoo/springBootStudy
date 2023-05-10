package com.springboot.learning;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.annotation.PostConstruct;


@SpringBootApplication
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
