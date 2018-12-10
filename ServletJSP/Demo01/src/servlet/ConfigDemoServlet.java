package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "ConfigDemoServlet", urlPatterns = "/configdemo",
        initParams = {
            @WebInitParam(name="admin", value="Harry Taciak"),
            @WebInitParam(name="email", value="admin@example.com")
        })
public class ConfigDemoServlet implements Servlet {
    private transient ServletConfig servletConfig;

    @Override
    public ServletConfig getServletConfig()
    {
        return servletConfig;
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException{
        this.servletConfig = servletConfig;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException
    {
        ServletConfig servletConfig = getServletConfig();
        String admin = servletConfig.getInitParameter("admin");
        String email = servletConfig.getInitParameter("email");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<html><body>Admin: "+admin +
                "<br> Email: " + email +
                "</body></html>");
    }

    @Override
    public String getServletInfo()
    {
        return "ServletConfig demo";
    }

    @Override
    public void destroy()
    {

    }


}
