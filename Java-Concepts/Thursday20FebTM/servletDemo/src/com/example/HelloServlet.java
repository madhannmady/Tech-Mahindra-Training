//package com.example;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class HelloServlet
// */
//@WebServlet("/HelloServlet")
//public class HelloServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public HelloServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}
//
//}


package com.example;

import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");      
        PrintWriter pwriter = response.getWriter();    
        pwriter.println("<html><body>");
        pwriter.println("<h1>Html file from Servlet!</h1>");
        pwriter.println("<form name='loginForm' action='loginServlet' method='post'>");  // Escaped quotes
        pwriter.println("Username: <input type=\"text\" name=\"username\"/> <br/>");
        pwriter.println("Password: <input type=\"password\" name=\"password\"/> <br/>");
        pwriter.println("<input type=\"submit\" value=\"Login\" />");
        pwriter.println("</form>");
        pwriter.println("</body></html>");
       
    }
}




