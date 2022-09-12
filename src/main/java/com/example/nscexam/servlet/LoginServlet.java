package com.example.nscexam.servlet;


import com.example.nscexam.dao.UserDao;
import com.example.nscexam.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao = new UserDao();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = dao.getUser(username, password); //'' or 1=1--;
        PrintWriter out = response.getWriter();
        if (user != null) {

            out.append(user.toString());
            out.close();
        }else {

            out.append("login error");
            out.close();        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
