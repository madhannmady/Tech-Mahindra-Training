package com.example.sample;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Cookie cookies[] = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    out.println("Cookie Name: " + cookie.getName() + "<br>");
                    out.println("Cookie Value: " + cookie.getValue() + "<br><br>");
                }
                out.println("Click on the below button to delete cookies.<br>");
                out.println("<form action='DeleteCookieServlet' method='POST'>");
                out.println("<input type='submit' value='Delete Cookies'>");
                out.println("</form>");
            } else {
                out.println("No cookies found.<br>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }
}