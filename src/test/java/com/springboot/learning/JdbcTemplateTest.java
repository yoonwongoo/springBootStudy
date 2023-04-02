package com.springboot.learning;


import com.springboot.LearningTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = LearningApplication.class)
@TestPropertySource("classpath:application.properties")
@Transactional
public class JdbcTemplateTest {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void init(){
        jdbcTemplate.execute("create table if not exists learning(" +
                "name varchar(100) primary key," +
                "count int)");
    }


    @Test
    void insertTest(){

        jdbcTemplate.update("insert into learning(name, count) values(?,?)","윤맹키", 1);
        jdbcTemplate.update("insert into learning(name, count) values(?,?)","맹맹이", 2);


        Long count = jdbcTemplate.queryForObject("select count(*) from learning", Long.class);
        assertThat(count).isEqualTo(2);

    }

    @Test
    void insertTest2(){

    jdbcTemplate.update("insert into learning(name, count) values(?,?)","윤맹키", 1);
    jdbcTemplate.update("insert into learning(name, count) values(?,?)","맹맹이", 2);


    Long count = jdbcTemplate.queryForObject("select count(*) from learning", Long.class);
    assertThat(count).isEqualTo(2);

    }


}
