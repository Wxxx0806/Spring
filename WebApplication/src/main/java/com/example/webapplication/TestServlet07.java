package com.example.webapplication;


import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

@WebServlet(name = "TestServlet07", urlPatterns = "/TestServlet07")
public class TestServlet07 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        ServletContext context = this.getServletContext();
        PrintWriter out = response.getWriter();
        InputStream stream=context.getResourceAsStream("/WEB-INF/classes/itcast.propertiess");

        Properties properties=new Properties();
        properties.load(stream);
        out.println("Company="+properties.getProperty("Company")+"<br />");
        out.println("Address="+properties.getProperty("Address")+"<br />");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request, response);
    }
}
