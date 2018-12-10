package servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FormServlet", urlPatterns = {"/form"})
public class FormServlet extends HttpServlet {
    private static final long serialVersionUID = 54L;
    private static final String TITLE = "Order Form";
    private String getHtml = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "\t<title>%s</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "\t<h1>\n" +
            "\t\t%s\n" +
            "\t</h1>\n" +
            "\t<form method='POST'>\n" +
            "\t\t<table>\n" +
            "\t\t\t<tr>\n" +
            "\t\t\t\t<td>Name:</td>\n" +
            "\t\t\t\t<td><input type='text' name='name' ></td>\n" +
            "\t\t\t</tr>\n" +
            "\t\t\t<tr>\n" +
            "\t\t\t\t<td>Address:</td>\n" +
            "\t\t\t\t<td><textarea name='address' cols='40' rows='4'></textarea></td>\n" +
            "\t\t\t</tr>\n" +
            "\t\t\t<tr>\n" +
            "\t\t\t\t<td>Country:</td>\n" +
            "\t\t\t\t<td>\n" +
            "\t\t\t\t\t<select name='country'>\n" +
            "\t\t\t\t\t\t<option>China</option>\n" +
            "\t\t\t\t\t\t<option>Canada</option>\n" +
            "\t\t\t\t\t\t<option>United States</option>\n" +
            "\t\t\t\t\t</select>\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t</tr>\n" +
            "\t\t\t<tr>\n" +
            "\t\t\t\t<td>&nbsp;</td>\n" +
            "\t\t\t\t<td>\n" +
            "\t\t\t\t\t<input type=\"reset\">\n" +
            "\t\t\t\t\t<input type=\"submit\">\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t</tr>" +
            "\t\t</table>\n" +
            "\t</form>\n" +
            "\n" +
            "</body>\n" +
            "</html>";
    public String postHtml = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "\t<title>%s</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "\t<h1>\n" +
            "\t\t%s\n" +
            "\t</h1>\n" +
            "\t<form method='POST'>\n" +
            "\t\t<table>\n" +
            "\t\t\t<tr>\n" +
            "\t\t\t\t<td>Name:</td>\n" +
            "\t\t\t\t<td>%s</td>\n" +
            "\t\t\t</tr>\n" +
            "\t\t\t<tr>\n" +
            "\t\t\t\t<td>Address:</td>\n" +
            "\t\t\t\t<td>%s</td>\n" +
            "\t\t\t</tr>\n" +
            "\t\t\t<tr>\n" +
            "\t\t\t\t<td>Country:</td>\n" +
            "\t\t\t\t<td>%s</td>\n" +
            "\n" +
            "\t\t\t</tr>\n" +
            "\t\t</table>\n" +
            "\t</form>\n" +
            "\n" +
            "</body>\n" +
            "</html>";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String html = String.format(getHtml, TITLE, TITLE);
        writer.print(html);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter  writer = response.getWriter();
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String country = request.getParameter("country");
        String html = String.format(postHtml, TITLE, TITLE, name, address, country);
        writer.print(html);
    }

}
