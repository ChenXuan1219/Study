package com.pinkman;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HttpServlet_Test extends HttpServlet {

    private String message;

    public void init() throws ServletException {
        // 执行必需的初始化
        message = "Hello World";
    }

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

    }

    public void destroy() {
        // 什么也不做
    }
}
