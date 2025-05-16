package com.example.webapplication;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "TestServlet04",urlPatterns = "/TestServlet04")
public class TestServlet04 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        ServletContext context=this.getServletContext();
        Enumeration<String> paramNames= context.getInitParameterNames();
        out.println("all the paramName and paramValue are following:");

        while (paramNames.hasMoreElements()){
            String name=paramNames.nextElement();
            String value= context.getInitParameter(name);
            out.println(name+":"+value);
            out.println("<br />");
        }
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        this.doGet(request,response);
    }
}
