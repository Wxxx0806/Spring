package com.example.webapplication;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ShowTimesServlet",urlPatterns = "/ShowTimesServlet")
public class ShowTimesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        // 获取ServletContext对象
        ServletContext context = getServletContext();

        // 从上下文中获取访问次数（若不存在则初始化为0）
        Integer times = (Integer) context.getAttribute("times");
        if (times == null) {
            times = 0;
        }

        // 访问次数+1
        times++;

        // 将新值保存回上下文
        context.setAttribute("times", times);

        // 向客户端输出结果
        out.print("网站已被访问 " + times + " 次");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
