package com.springboot;


import com.springboot.learning.LearningApplication;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = LearningApplication.class)
@TestPropertySource("classpath:application.properties")
@Transactional
public @interface LearningTest {
}
