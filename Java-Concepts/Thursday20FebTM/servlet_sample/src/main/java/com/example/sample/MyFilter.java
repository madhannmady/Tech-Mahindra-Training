package com.example.sample;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter implements Filter {
    private FilterConfig filterConfig;

    public void init(FilterConfig filterConfig)
            throws ServletException {
        this.filterConfig = filterConfig;
    }
    public void doFilter(ServletRequest request,
                         ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //get parameters from filterConfig object.
        String appUser = filterConfig.getInitParameter("appUser");
        if(appUser.equals("jai")){
            chain.doFilter(request, response);
        }
        else {out.print("Invalid application user.");} }

    public void destroy() { } }