package cookie;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CookieServlet", urlPatterns = {"/cookie"})
public class CookieServlet extends HttpServlet {
    private String html = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "\t<title>Cookie</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "\t<h2>\n" +
            "\t\tCookieEdit Customer\n" +
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
        cookieView(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        updateCookie(request, response);
    }

    private void cookieView(HttpServletRequest request, HttpServletResponse response)
            throws IOException
    {

        Cookie[] cookies = request.getCookies();
        String name = "kingkk";
        String country = "China";
        int age = 19;

        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("name")){
                    name = cookie.getValue();
                }else if(cookie.getName().equals("country")){
                    country = cookie.getValue();
                }else if(cookie.getName().equals("age")){
                    age = Integer.parseInt(cookie.getValue());
                }
            }
        }
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print(String.format(html, name, country, age));


    }

    private void updateCookie(HttpServletRequest request, HttpServletResponse response)
            throws IOException
    {
        String name = request.getParameter("name") != null ? request.getParameter("name") : "kingkk";
        String city = request.getParameter("country") != null ? request.getParameter("country") : "China";
        int age = 19;
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        try {
            age = Integer.parseInt(request.getParameter("age"));
        }catch (NumberFormatException e){
            writer.print("age must be int");
        }

        Cookie nameCookie = new Cookie("name", name);
        Cookie cityCookie = new Cookie("country", city);
        Cookie ageCookie = new Cookie("age", String.valueOf(age));

        response.addCookie(nameCookie);
        response.addCookie(cityCookie);
        response.addCookie(ageCookie);

        writer.print(String.format(html, name, city, age));


    }

}
