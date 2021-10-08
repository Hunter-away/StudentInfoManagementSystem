package com.rsw.servlet.login;

import com.rsw.dao.Imp.StudentImp;
import com.rsw.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/loginCheckForStudent")
public class loginCheckForStudent extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");

        //获取参数
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");

        //获取验证码
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");

        if(checkCode_session != null && checkCode_session.equalsIgnoreCase(checkCode)) {
            //验证码正确
            Student loginStudent = new Student();
            loginStudent.setSno(id);
            loginStudent.setPassword(password);

            Student student = new StudentImp().login(loginStudent);

            if(student!=null){
                //存储用户信息
                session.setAttribute("student",student.getSname());
                //重定位到成功页面

                response.sendRedirect(request.getContextPath()+"/findAllCourseByPage");


            }else{
                //用户名或者密码错误
                request.setAttribute("login_error","用户名或者密码错误");//session
                //转发到登录页面
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }
        else{
            //验证码不一致
            request.setAttribute("cc_error","验证码错误");//session
            //转发到登录页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
