package com.rsw.servlet.course;

import com.rsw.dao.CourseDao;
import com.rsw.dao.Imp.CourseImp;
import com.rsw.dao.TeacherDao;
import com.rsw.entity.Course;
import com.rsw.entity.PageBean;
import com.rsw.entity.Teacher;
import com.rsw.service.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/findAllCourseByPage")
public class findAllCourse extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String teacher = request.getParameter("course-search");


        if (teacher == null || "".equals(teacher)){
            teacher = "1";
        }

        System.out.println("--1---------");
        System.out.println(teacher);
        System.out.println("-----------");

        PageBean<Course> pb = new CourseService().findByPage(teacher);
        //存入
        request.setAttribute("pb",pb);

        //必须得转发
        request.getRequestDispatcher("/display.jsp").forward(request,response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
