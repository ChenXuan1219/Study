package com.pinkman;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet_Test implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

        System.out.println(servletConfig.getServletName());
        System.out.println("servlet is init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        System.out.println(servletRequest.getLocalPort());

        servletResponse.setContentType("text/html");
        PrintWriter writer = servletResponse.getWriter();
        writer.println("hello Servlet");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
