package com.springboot.learning;

public class Learning {

    private String studentName;

    private int attendanceCount;


    public Learning(String studentName, int attendanceCount) {
        this.studentName = studentName;
        this.attendanceCount = attendanceCount;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAttendanceCount() {
        return attendanceCount;
    }

    public void setAttendanceCount(int attendanceCount) {
        this.attendanceCount = attendanceCount;
    }
}
