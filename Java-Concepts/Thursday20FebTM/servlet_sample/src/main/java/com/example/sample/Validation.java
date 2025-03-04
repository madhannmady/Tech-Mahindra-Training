package com.example.sample;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Validation extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pwriter = response.getWriter();
        String name = request.getParameter("uname");
        String pass = request.getParameter("upass");
        if (name.equals("Mady") && pass.equals("1234")) {
            RequestDispatcher dis = request.getRequestDispatcher("welcome");
            dis.forward(request, response);
        } else {
            pwriter.print("User name or password is incorrect!");
            RequestDispatcher dis = request.getRequestDispatcher("index.html");
            dis.include(request, response);                                }
    }
}
