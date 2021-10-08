package com.rsw.servlet.student;

import com.rsw.entity.Course;
import com.rsw.entity.PageBean;
import com.rsw.entity.Student;
import com.rsw.service.CourseService;
import com.rsw.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/findAllStudent")
public class findAllStudent extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String student = request.getParameter("course-search");
        String teachername = (String) request.getSession().getAttribute("teacher");

        if (student == null || "".equals(student)){
            student = "1";
        }


        PageBean<Student> pb = new StudentService().findByPage(student,teachername);
        //存入
        request.setAttribute("pbs",pb);

        //必须得转发
        request.getRequestDispatcher("/Teacher.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
