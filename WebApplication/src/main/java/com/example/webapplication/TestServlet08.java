package com.example.webapplication;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

@WebServlet(name = "TestServlet08", urlPatterns = "/TestServlet08")
public class TestServlet08 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext context = this.getServletContext();
        PrintWriter out = response.getWriter();
        String path =context.getRealPath("/WEB-INF/classes/itcast.propertiess");
        FileInputStream in=new FileInputStream(path);
        Properties properties=new Properties();
        properties.load(in);
        out.println("Company="+properties.getProperty("Company"));
        out.println("Address="+properties.getProperty("Address"));
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request, response);
    }
}
