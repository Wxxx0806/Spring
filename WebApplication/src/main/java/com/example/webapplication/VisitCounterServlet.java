package com.example.webapplication;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

@WebServlet(name = "VisitCounterServlet", urlPatterns = "/VisitCounterServlet")
public class VisitCounterServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        // 处理重置请求
        String action = request.getParameter("action");
        if ("reset".equals(action)) {
            resetCounter(response);
            out.println("计数器已重置！<br>");
            out.println("<a href='VisitCounterServlet'>返回</a>");
            return;
        }

        Cookie visitCookie = findCookie(request.getCookies(), "visitCount");
        int visitCount = 1;

        if (visitCookie != null) {
            // 非首次访问：获取并递增访问次数
            try {
                visitCount = Integer.parseInt(URLDecoder.decode(visitCookie.getValue(), "UTF-8")) + 1;
            } catch (NumberFormatException e) {
                visitCount = 1; // 值无效时重置
            }
            out.println("欢迎回来！这是您第" + visitCount + "次访问本站。<br>");
        } else {
            // 首次访问
            out.println("欢迎首次访问！<br>");
        }

        // 更新或创建Cookie
        Cookie newCookie = new Cookie("visitCount", URLEncoder.encode(String.valueOf(visitCount), "UTF-8"));
        newCookie.setMaxAge(30 * 24 * 3600); // 持久化30天
        newCookie.setPath("/");
        response.addCookie(newCookie);

        // 添加重置链接
        out.println("<a href='VisitCounterServlet?action=reset'>重置计数器</a>");
    }

    // 查找指定名称的Cookie
    private Cookie findCookie(Cookie[] cookies, String name) {
        if (cookies == null) return null;
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie;
            }
        }
        return null;
    }

    // 重置计数器（删除Cookie）
    private void resetCounter(HttpServletResponse response) {
        Cookie cookie = new Cookie("visitCount", "");
        cookie.setMaxAge(0); // 立即过期
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}