package com.springboot.learning;

public interface LearningRepository {

    Learning findLearning(String name);

    void increaseAttendanceCount(String name);

    default int attendanceCountOf(String name){
        Learning learning = findLearning(name);
        return learning == null ? 0 : learning.getAttendanceCount();
    }
}
