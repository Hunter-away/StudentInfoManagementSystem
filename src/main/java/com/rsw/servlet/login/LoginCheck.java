package com.rsw.servlet.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/loginCheck")
public class LoginCheck extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");

        //获取参数
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");
        String identity = request.getParameter("identity");

        HttpSession session = request.getSession();
        session.setAttribute("userid",id);

        if ("student".equals(identity)){
            response.sendRedirect(request.getContextPath()+"/loginCheckForStudent?id="+id+"&password="+password+"&checkCode="+checkCode);
        }
        else{
            response.sendRedirect(request.getContextPath()+"/loginCheckForTeacher?id="+id+"&password="+password+"&checkCode="+checkCode);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
