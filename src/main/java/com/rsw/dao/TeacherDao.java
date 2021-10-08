package com.rsw.dao;

import com.rsw.entity.Teacher;

import java.util.List;

public interface TeacherDao {
    public List<Teacher> findAllTeacher();

    Teacher login(Teacher loginTeacher);
}
