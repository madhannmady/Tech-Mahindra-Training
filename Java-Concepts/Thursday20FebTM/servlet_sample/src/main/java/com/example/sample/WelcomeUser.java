package com.example.sample;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class WelcomeUser extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pwriter = response.getWriter();
        String name = request.getParameter("uname");
        pwriter.print("Hello " + name + "!");
        pwriter.print(" Welcome to Beginnersbook.com");
    }
}
