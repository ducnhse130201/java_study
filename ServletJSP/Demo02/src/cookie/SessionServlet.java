package cookie;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SessionServlet", urlPatterns = {"/session"})
public class SessionServlet  extends HttpServlet {
    private String html = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "\t<title>Session</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "\t<h2>\n" +
            "\t\tSessionEdit Customer\n" +
            "\t</h2>\n" +
            "\t<form method=\"POST\" >\n" +
            "\t\t<table>\n" +
            "\t\t\t<tr>\n" +
            "\t\t\t\t<td>\n" +
            "\t\t\t\t\tName:\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t\t<td>\n" +
            "\t\t\t\t\t<input type=\"text\" name=\"name\" value=\"%s\">\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t</tr>\n" +
            "\t\t\t<tr>\n" +
            "\t\t\t\t<td>\n" +
            "\t\t\t\t\tCountry:\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t\t<td>\n" +
            "\t\t\t\t\t<input type=\"text\" name=\"country\" value=\"%s\">\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t</tr>\n" +
            "\t\t\t<tr>\n" +
            "\t\t\t\t<td>\n" +
            "\t\t\t\t\tAge:\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t\t<td>\n" +
            "\t\t\t\t\t<input type=\"text\" name=\"age\" value=\"%d\">\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t</tr>\n" +
            "\n" +
            "\t\t\t<br>\n" +
            "\t\t\t<td colspan=\"2\" style=\"text-align:right\">\n" +
            "\t\t\t\t<input type=\"submit\" value=\"Update\">\n" +
            "\t\t\t</td>\n" +
            "\t\t\t\n" +
            "\t\t</table>\n" +
            "\t</form>\n" +
            "</body>\n" +
            "</html>";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        String name = session.getAttribute("name") != null ? (String)session.getAttribute("name") : "kingkk";
        String coutry = session.getAttribute("country") != null ? (String)session.getAttribute("country") : "China";
        String _age = session.getAttribute("age") != null ? (String)session.getAttribute("age") : "20";
        int age = 20;
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        try {
            age = Integer.parseInt( _age);
        }catch (NumberFormatException e){
            writer.print("age must be int");
        }

        writer.print(String.format(html, name, coutry, age));

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();

        String name = request.getParameter("name") != null ? request.getParameter("name") : "kingkk";
        String country = request.getParameter("country") != null ? request.getParameter("country") : "China";
        int age = 20;
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        try {
            age = Integer.parseInt(request.getParameter("age"));
        }catch (NumberFormatException e){
            writer.print("age must be int");
        }

        session.setAttribute("name", name);
        session.setAttribute("country", country);
        session.setAttribute("age", age);

        writer.print(String.format(html, name, country, age));




    }




}




