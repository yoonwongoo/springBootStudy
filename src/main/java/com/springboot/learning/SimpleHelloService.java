package com.springboot.learning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimpleHelloService implements HelloService {



    private final LearningRepository learningRepository;

    public SimpleHelloService(LearningRepository learningRepository) {
        this.learningRepository = learningRepository;
    }

    @Override
    public String hello(String name){
        learningRepository.increaseAttendanceCount(name);
        return "Simple Hello Service"+name;
    }

    @Override
    public int helloCount(String name) {
        return learningRepository.attendanceCountOf(name);
    }
}

