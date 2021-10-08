package com.rsw.servlet.mycourse;

import com.google.gson.Gson;
import com.rsw.dao.Imp.CourseImp;
import com.rsw.entity.BaseResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/delCourseInfo")
public class DelCourseInfo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String course = request.getParameter("course");

        BaseResponse<Integer> baseResponse = new BaseResponse<Integer>();
        int rows = new CourseImp().DelCourseInfo(course);

        if (rows > 0){
            baseResponse.setCode(200);
            baseResponse.setMsg("Delete successfully!!!");
        }
        else{
            baseResponse.setCode(600);
            baseResponse.setMsg("Delete failed!!!");
        }

        baseResponse.setData(rows);
        baseResponse.setCount(rows);

        Gson gson = new Gson();
        String json = gson.toJson(baseResponse);

        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
