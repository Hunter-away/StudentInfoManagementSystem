package com.rsw.service;

import com.rsw.dao.CourseDao;
import com.rsw.dao.Imp.CourseImp;
import com.rsw.entity.Course;
import com.rsw.entity.PageBean;

import java.util.List;

public class CourseService {
    public PageBean<Course> findByPage(String teacher){
        PageBean<Course> pb = new PageBean<Course>();
        int rows = 5;
        pb.setRows(rows);
        pb.setCurrentPage(1);

        List<Course> list = new CourseImp().findAllCourse(teacher);

        pb.setList(list);

        int totalCount = new CourseImp().findTotal();
        pb.setTotalCount(totalCount);

        int totalPage = totalCount % rows == 0 ? totalCount / rows : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);

        return pb;
    }


}
