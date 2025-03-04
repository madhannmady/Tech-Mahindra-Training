package com.example.sample;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


public class SetUrlParameterServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //get parameters from request object.
        String userName = request.getParameter("userName").trim();
        String password = request.getParameter("password").trim();
//check for null and empty values.
        if(userName == null || userName.equals("") ||
                password == null || password.equals("")){
            out.print("Please enter both username and " +
                    "password. <br><br>");
            RequestDispatcher requestDispatcher =
                    request.getRequestDispatcher("/login.html");
            requestDispatcher.include(request, response);
        }//Check for valid username and password.
//        else if(userName.equals("aia") && password.equals("435465")){
//            out.println("Logged in successfully.<br>");
//            out.println("Click on the below link to see " +
//                    "the values of Username and Password.<br>");
//            RequestDispatcher requestDispatcher =
//                    request.getRequestDispatcher("/login.html");
//            requestDispatcher.include(request, response);
//        }//Check for valid username and password.
        else if(userName.equals("jk") && password.equals("1234")){
            out.println("Logged in successfully.<br>");
            out.println("Click on the below link to see " +
                    "the values of Username and Password.<br>");
            out.println("<a href=\"GetUrlParameterServlet?userName=" + userName + "&password=" + password + "\">Click here</a>");
        }else{
            out.print("Wrong username or password. <br><br>");
            RequestDispatcher requestDispatcher =
                    request.getRequestDispatcher("/login.html");
            requestDispatcher.include(request, response);
        }    }}