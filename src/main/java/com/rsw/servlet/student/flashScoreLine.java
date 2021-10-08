package com.rsw.servlet.student;

import com.google.gson.Gson;
import com.rsw.dao.Imp.StudentImp;
import com.rsw.dao.Imp.userTeacherImp;
import com.rsw.entity.CourseInfo;
import com.rsw.entity.UserTeacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/flashScoreLine")
public class flashScoreLine extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String teacher = (String) request.getSession().getAttribute("teacher");
        List<UserTeacher> userTeachers = new ArrayList<UserTeacher>();
        userTeachers = new userTeacherImp().queryStudentByTeacher(teacher);

        List<String> sname = new ArrayList<String>();
        List<Integer> score = new ArrayList<Integer>();

        for (UserTeacher userTeacher : userTeachers) {
            sname.add(userTeacher.getUid());
            if (userTeacher.getScore() == null || "".equals(userTeacher.getScore())){
                score.add(0);
            }
            else{
                score.add(Integer.parseInt(userTeacher.getScore()));
            }

        }

        CourseInfo courseInfo = new CourseInfo();
        courseInfo.setNames(sname);
        courseInfo.setLessonPeriod(score);

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
