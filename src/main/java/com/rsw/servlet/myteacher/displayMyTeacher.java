package com.rsw.servlet.myteacher;


import com.google.gson.Gson;
import com.rsw.dao.Imp.userTeacherImp;
import com.rsw.entity.BaseResponse;
import com.rsw.entity.Student;
import com.rsw.entity.UserTeacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/displayMyTeacher")
public class displayMyTeacher extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String id = (String)request.getSession().getAttribute("userid");
        List<UserTeacher> teachers = new ArrayList<UserTeacher>();
        teachers = new userTeacherImp().queryTeacherById(id);

        

        BaseResponse<List<UserTeacher>> baseResponse = new BaseResponse<List<UserTeacher>>();
        baseResponse.setCode(0);
        baseResponse.setMsg("请求成功");
        baseResponse.setData(teachers);
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
