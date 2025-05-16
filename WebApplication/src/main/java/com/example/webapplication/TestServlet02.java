package com.example.webapplication;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet(name = "TestServlet02",urlPatterns = "/TestServlet02")
public class TestServlet02 extends GenericServlet {

    @Override
    public void init() {
        System.out.println("已初始化");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) {
        System.out.println("Hello World");
    }

    @Override
    public void destroy() {
        System.out.println("已销毁");
    }
}
