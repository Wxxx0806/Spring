package com.example.webapplication;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "RequestHeaderServlet01",urlPatterns = "/RequestHeaderServlet01")
public class RequestHeaderServlet01 extends HelloServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Enumeration headNames = request.getHeaderNames();
        while (headNames.hasMoreElements()) {
            String headName = (String) headNames.nextElement();
            out.print(headName + ":" + request.getHeader(headName) + "<br />");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
