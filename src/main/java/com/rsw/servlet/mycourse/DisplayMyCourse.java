package com.rsw.servlet.mycourse;

import com.google.gson.Gson;
import com.rsw.dao.Imp.userTeacherImp;
import com.rsw.entity.BaseResponse;
import com.rsw.entity.UserCourse;
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

@WebServlet(urlPatterns = "/displayMyCourse")
public class DisplayMyCourse extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String id = (String)request.getSession().getAttribute("userid");
        List<UserCourse> courses = new ArrayList<UserCourse>();
        courses = new userTeacherImp().queryCourseById(id);

        BaseResponse<List<UserCourse>> baseResponse = new BaseResponse<List<UserCourse>>();
        baseResponse.setCode(0);
        baseResponse.setMsg("请求成功");
        baseResponse.setData(courses);
        baseResponse.setCount(20);

        Gson gson = new Gson();
        String json =gson.toJson(baseResponse);

        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
