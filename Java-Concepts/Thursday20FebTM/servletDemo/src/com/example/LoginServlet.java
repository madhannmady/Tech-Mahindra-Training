package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get user input
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Print to console (for debugging)
        System.out.println("username: " + username);
        System.out.println("password: " + password);

        // Display response in browser
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String htmlResponse = "<html>";
        htmlResponse += "<h2>Your username is: " + username + "<br/>";
        htmlResponse += "Your password is: " + password + "</h2></html>";
        writer.println(htmlResponse);
    }
}
