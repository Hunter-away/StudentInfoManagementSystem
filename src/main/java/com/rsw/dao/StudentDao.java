package com.rsw.dao;

import com.rsw.entity.Student;

import java.util.List;

public interface StudentDao {
    public Student login(Student student);
    public List<Student> findAllStudent(String student,String teacher);

    int insertScore(String id, String score, String teacher);

//    String queryById(String uid);
}
