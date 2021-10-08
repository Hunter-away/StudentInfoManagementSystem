package com.rsw.servlet.student;

import com.google.gson.Gson;
import com.rsw.dao.Imp.userTeacherImp;
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

@WebServlet(urlPatterns = "/flashWork")
public class flashWork extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String teacher = (String) request.getSession().getAttribute("teacher");

        System.out.println(teacher);
        List<String> sname = new ArrayList<String>();
        List<Integer> finishOrN = new ArrayList<Integer>();


        String s1 = "Done";
        String s2 = "Incomplete";
        sname.add(s1);
        sname.add(s2);

        int finish = new userTeacherImp().queryFinish(teacher);
        int total = new userTeacherImp().queryTotal(teacher);

        finishOrN.add(finish);
        finishOrN.add(total-finish);

        CourseInfo courseInfo = new CourseInfo();
        courseInfo.setNames(sname);
        courseInfo.setLessonPeriod(finishOrN);

        Gson gson = new Gson();
        String json = gson.toJson(courseInfo);

        PrintWriter out = response.getWriter();
        out.write(json);
        out.flush();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
