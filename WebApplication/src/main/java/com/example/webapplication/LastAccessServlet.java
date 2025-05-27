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
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "LastAccessServlet", urlPatterns = "/LastAccessServlet")
public class LastAccessServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Cookie[] cookies = request.getCookies();
        boolean hasLastAccess = false;

        // 遍历查找名为 "lastAccess" 的Cookie
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("lastAccess".equals(cookie.getName())) {
                    hasLastAccess = true;
                    String lastAccessTime = URLDecoder.decode(cookie.getValue(), "utf-8");
                    out.println("上次访问时间：" + lastAccessTime);

                    // 更新Cookie值为当前时间
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String currentTime = URLEncoder.encode(sdf.format(new Date()), "utf-8");
                    cookie.setValue(currentTime);
                    cookie.setMaxAge(3600);
                    cookie.setPath("/"); // 设置全局路径
                    response.addCookie(cookie);
                    break;
                }
            }
        }

        // 未找到Cookie时，创建新的 "lastAccess" Cookie
        if (!hasLastAccess) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String currentTime = URLEncoder.encode(sdf.format(new Date()), "utf-8");
            Cookie newCookie = new Cookie("lastAccess", currentTime); // 名称改为 lastAccess
            newCookie.setMaxAge(3600);
            newCookie.setPath("/"); // 设置全局路径
            response.addCookie(newCookie);
            out.println("欢迎首次访问！");
        }
    }
}
