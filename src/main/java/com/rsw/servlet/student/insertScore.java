package com.rsw.servlet.student;

import com.google.gson.Gson;
import com.rsw.dao.Imp.StudentImp;
import com.rsw.entity.BaseResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/insertScore")
public class insertScore extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String id = request.getParameter("stuid");
        String score = request.getParameter("score");
        String teacher =(String) request.getSession().getAttribute("teacher");

        BaseResponse<Integer> baseResponse = new BaseResponse<Integer>();

        int rows = new StudentImp().insertScore(id,score,teacher);

        if (rows > 0){
            baseResponse.setCode(200);
            baseResponse.setMsg("Success!");
        }
        else {
            baseResponse.setCode(600);
            baseResponse.setMsg("Failed!");
        }

        Gson gson = new Gson();
        String json = gson.toJson(baseResponse);
        PrintWriter out = response.getWriter();
        out.write(json);
        out.flush();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
