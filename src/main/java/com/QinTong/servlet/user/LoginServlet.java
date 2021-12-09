package com.QinTong.servlet.user;

import com.QinTong.pojo.User;
import com.QinTong.service.user.UserService;
import com.QinTong.service.user.UserServiceImpl;
import com.QinTong.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.invoke.ConstantCallSite;

public class LoginServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginServlet--start...");

        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");

        UserService userService = new UserServiceImpl();
        User user = userService.login(userCode, userPassword);

        if(user!=null){
            //将用户信息放到session中
            req.getSession().setAttribute(Constants.USER_SESSION, user);
            //跳转到内部主页
            resp.sendRedirect("jsp/frame.jsp");
        }else{
            req.setAttribute("error","用户名或密码错误");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
