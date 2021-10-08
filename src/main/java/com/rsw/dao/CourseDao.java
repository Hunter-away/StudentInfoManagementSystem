package com.rsw.dao;

import com.rsw.entity.Course;
import com.rsw.entity.PageBean;

import java.util.List;

public interface CourseDao {

    public int findTotal();

    List<Course> getUserCourse(String id);

    int DelCourseInfo(String course);
    public List<Course> findAllCourse(String teacher);
}
