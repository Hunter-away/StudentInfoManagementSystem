package com.rsw.servlet.mycourse;

import com.google.gson.Gson;
import com.rsw.dao.Imp.CourseImp;
import com.rsw.entity.Course;
import com.rsw.entity.CourseInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/displayCourseInfo")
public class DisplayCourseInfo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String id = (String)request.getSession().getAttribute("userid");

        List<Course> courses = new ArrayList<Course>();
        courses = new CourseImp().getUserCourse(id);

        List<String> Name = new ArrayList<String>();
        List<Integer> LessonPeriod = new ArrayList<Integer>();
        for (Course cours : courses) {
            Name.add(cours.getName());
            LessonPeriod.add(cours.getLessonPeriod());
        }
        //渲染数据到后台

        CourseInfo objects = new CourseInfo();
        objects.setNames(Name);
        objects.setLessonPeriod(LessonPeriod);


        Gson gson = new Gson();
        String json =gson.toJson(objects);

        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
