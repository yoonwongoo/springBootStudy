package com.springboot.learning;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class LearningRepositoryJdbcTemplate implements LearningRepository{

    private final JdbcTemplate jdbcTemplate;

    public LearningRepositoryJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Learning findLearning(String name) {
        try{
            return  jdbcTemplate.queryForObject("select * from learning where studentName ='" + name + "'",
                            (rs,rowNum)-> new Learning(rs.getString("studentName"),rs.getInt("attendanceCount")));


        }catch(EmptyResultDataAccessException e){

            return null;
        }


    }

    @Override
    public void increaseAttendanceCount(String name) {
       Learning learning = findLearning(name);
       if(ObjectUtils.isEmpty(learning)) jdbcTemplate.update("insert into learning(studentName,attendanceCount) values(?,?)",name,1);
       else jdbcTemplate.update("update learning set attendanceCount =? where studentName=?",learning.getAttendanceCount()+1,name);
    }
}
