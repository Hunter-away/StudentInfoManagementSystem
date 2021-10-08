package com.rsw.dao;

import com.rsw.entity.UserCourse;
import com.rsw.entity.UserTeacher;

import java.util.List;

public interface userTeacher {
    public int insert(String id, String teacher,String Cname);

    List<UserTeacher> queryTeacherById(String id);

    UserTeacher queryTeacherByNameAndId(String teacher, String id);

    List<UserCourse> queryCourseById(String id);

    public int queryFinish(String teacher);

    List<UserTeacher> queryStudentByTeacher(String teacher);

    int queryTotal(String teacher);
}
