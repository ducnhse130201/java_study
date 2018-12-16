package listener;

import model.Product;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.HashMap;

@WebListener
public class AppListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent sce){}

    @Override
    public void contextInitialized(ServletContextEvent sce){
        ServletContext servletContext = sce.getServletContext();

        HashMap<String, String> countires = new HashMap<>();
        countires.put("ca", "Cananda");
        countires.put("us", "United States");
        servletContext.setAttribute("countries", countires);


    }


}
