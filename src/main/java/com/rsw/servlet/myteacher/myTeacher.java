package com.rsw.servlet.myteacher;

import com.google.gson.Gson;
import com.rsw.dao.Imp.userTeacherImp;
import com.rsw.entity.BaseResponse;
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

@WebServlet(urlPatterns = "/myTeacher")
public class myTeacher extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String teacher = request.getParameter("Teacher");
        String id =(String)request.getSession().getAttribute("userid");
        String Cname = request.getParameter("CName");

        System.out.println(teacher);
        System.out.println(Cname);

        List<UserTeacher> teachers = new ArrayList<UserTeacher>();
        teachers = new userTeacherImp().queryTeacherById(id);

        boolean flag = false;

        //判断数据库中老师是否已经存在
        for (UserTeacher userTeacher : teachers) {
            if (userTeacher.getTeacher().equals(teacher)){
                flag = true;
            }
        }

        BaseResponse<List<UserTeacher>> baseResponse = new BaseResponse<List<UserTeacher>>();

        if (flag == false) {
            int rows = new userTeacherImp().insert(id, teacher, Cname);
            System.out.println(rows);

            //设置数据并传回客户端
            if (rows == 1) {
                baseResponse.setCode(200);
            }
            //存入
            baseResponse.setMsg("请求成功");
            baseResponse.setCount(20);
        }else{
            baseResponse.setCode(0);
            baseResponse.setMsg("你已经选过该课程");
            baseResponse.setCount(0);
        }

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
