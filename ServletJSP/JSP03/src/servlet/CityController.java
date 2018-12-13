package servlet;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(urlPatterns = {"/bigCities"})
public class CityController extends HttpServlet {
    private static final int serialVersionUID = 112233;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{

        HashMap<String, String> capitals = new HashMap<>();
        capitals.put("Indonesia", "Jakata");
        capitals.put("Malaysia", "Kuala Lumpur");
        capitals.put("Thailand", "Bangkok");
        request.setAttribute("capitals", capitals);

        HashMap<String, String[]> bigCities = new HashMap<>();
        bigCities.put("Australia", new String[]{"<img src=x onerror=alert`1`>", "Christchunrch", "Wellington"});
        bigCities.put("New Zealand", new String[]{"Auckland", "Melbourne", "Perth"});
        bigCities.put("Indonesia", new String[]{"Jakarta", "Surabaya", "Medan"});

        request.setAttribute("bigCities", bigCities);
        RequestDispatcher rd = request.getRequestDispatcher("/Cities.jsp");
        rd.forward(request, response);







    }


}
