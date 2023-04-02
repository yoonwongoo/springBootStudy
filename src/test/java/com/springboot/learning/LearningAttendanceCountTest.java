package com.springboot.learning;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.IntStream;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = LearningApplication.class)
@TestPropertySource(locations = "classpath:/application.properties")
public class LearningAttendanceCountTest {
    private  String name="윤맹키";
    @Autowired
    private HelloService helloService;

    @Autowired
    private LearningRepository learningRepository;

    @Test
    public void 출석카운트체크(){
        IntStream.rangeClosed(1,10).forEach(c->{
            helloService.hello(name);
            Assertions.assertThat(learningRepository.attendanceCountOf(name)).isEqualTo(c);
        });

    }
}
