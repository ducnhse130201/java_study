package servlet;


import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "GenericDemoServlet", urlPatterns = "/generic", initParams = {
        @WebInitParam(name="admin", value="Harry Tacick"),
        @WebInitParam(name="email", value="admin@example.com")
})
public class GenericDemoServlet extends GenericServlet {
    private static final long serialVersionUID = 62500890L;

    @Override
    public void service(ServletRequest request, ServletResponse response)
        throws ServletException, IOException
    {
        ServletConfig  servletConfig = getServletConfig();
        String admin = servletConfig.getInitParameter("admin");
        String email = servletConfig.getInitParameter("email");

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        writer.print("<html><body>Genric Admin:"+
                admin+"<br>Generic Email:"+ email +
                "</body></html>");


    }
}
