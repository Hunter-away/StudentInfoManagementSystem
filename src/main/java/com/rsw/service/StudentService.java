package com.rsw.service;

import com.rsw.dao.Imp.CourseImp;
import com.rsw.dao.Imp.StudentImp;
import com.rsw.entity.Course;
import com.rsw.entity.PageBean;
import com.rsw.entity.Student;

import java.util.List;

public class StudentService {
    public PageBean<Student> findByPage(String student,String teacher){
        PageBean<Student> pb = new PageBean<Student>();
        int rows = 5;
        pb.setRows(rows);
        pb.setCurrentPage(1);

        List<Student> list = new StudentImp().findAllStudent(student,teacher);

        pb.setList(list);

        int totalCount = new CourseImp().findTotal();
        pb.setTotalCount(totalCount);

        int totalPage = totalCount % rows == 0 ? totalCount / rows : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);

        return pb;
    }
}
