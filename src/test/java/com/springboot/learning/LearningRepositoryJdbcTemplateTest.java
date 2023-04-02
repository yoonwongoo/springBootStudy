package com.springboot.learning;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = LearningApplication.class)
@TestPropertySource(locations = "classpath:/application.properties")
class LearningRepositoryJdbcTemplateTest {

    @Autowired
    private LearningRepository learningRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void init(){
    jdbcTemplate.execute("create table if not exists learning(" +
    "studentName varchar(100) primary key," +
    "attendanceCount int)");
    }
    @Test
    void 학생찾기null일경우(){
        assertThat(learningRepository.findLearning("아무개")).isNull();
    }

    @Test
    void 학생찾기null이아닐경우(){
        learningRepository.increaseAttendanceCount("아무개");
        assertThat(learningRepository.attendanceCountOf("아무개")).isEqualTo(1);

        learningRepository.increaseAttendanceCount("아무개");
        assertThat(learningRepository.attendanceCountOf("아무개")).isEqualTo(2);

    }
}