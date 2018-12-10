package hiddenfields;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name="CustomerServlet", urlPatterns = {"/customer", "/editCustomer", "/updateCustomer"})
public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID = -20L;
    private ArrayList<Customer> customers = new ArrayList<Customer>();

    @Override
    public void init() throws ServletException{
        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setName("Donald D.");
        customer1.setCity("China");
        customers.add(customer1);

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setName("Mickey M.");
        customer2.setCity("Orlando");
        customers.add(customer2);

    }


    private void sendCustomerList(HttpServletResponse response)
        throws IOException
    {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String html = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\t<title>Customers</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<h2>\n" +
                "\t\tCustomers\n" +
                "\t</h2>\n" +
                "\t<ul>%s</ul>\n" +
                "</body>\n" +
                "</html>";
        StringBuilder ul = new StringBuilder();

        for (Customer customer: customers){
            ul.append("<li>" + customer.getName() +
                    "(" + customer.getCity() + ") (" +
                    "<a href='editCustomer?id=" + customer.getId() +
                    "'>edit</a>)");
        }

        writer.print(String.format(html, ul.toString()));

    }

    private Customer getCustomer(int customerId){
        for(Customer customer : customers){
            if(customer.getId() == customerId){
                return customer;
            }
        }
        return  null;
    }

    private String htmlEscape(String html){
        return html.replaceAll("'", "&#39;");
    }

    private void sendEditCustomerForm(HttpServletRequest request, HttpServletResponse response)
        throws IOException{
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        int customerId = 0;
        try{
            customerId = Integer.parseInt(request.getParameter("id"));
        }catch (NumberFormatException e){

        }

        Customer customer = getCustomer(customerId);

        if(customer != null){
            String html = "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "\t<title>Edit</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "\t<h2>\n" +
                    "\t\tEdit Customer\n" +
                    "\t</h2>\n" +
                    "\t<form method=\"POST\" action=\"updateCustomer\">\n" +
                    "\t\t<input type=\"hidden\" name=\"id\" value=\"%s\">\n" +
                    "\t\t<table>\n" +
                    "\t\t\t<tr>\n" +
                    "\t\t\t\t<td>\n" +
                    "\t\t\t\t\t<input type=\"text\" name=\"name\" value=\"%s\">\n" +
                    "\t\t\t\t</td>\n" +
                    "\t\t\t\t<td>\n" +
                    "\t\t\t\t\t<input type=\"text\" name=\"city\" value=\"%s\">\n" +
                    "\t\t\t\t</td>\n" +
                    "\t\t\t\t<td colspan=\"2\" style=\"text-align:right\">\n" +
                    "\t\t\t\t\t<input type=\"submit\" value=\"Update\">\n" +
                    "\t\t\t\t</td>\n" +
                    "\t\t\t\t<td colspan=\"2\">\n" +
                    "\t\t\t\t\t<a href=\"customer\">Customer List</a>\n" +
                    "\t\t\t\t</td>\n" +
                    "\t\t\t</tr>\n" +
                    "\t\t</table>\n" +
                    "\t</form>\n" +
                    "</body>\n" +
                    "</html>";
            writer.print(String.format(html, customer.getId(),
                    htmlEscape(customer.getName()), htmlEscape(customer.getCity())));

        }else {
            writer.println("No customer found.");
        }

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String uri = request.getRequestURI();
        if(uri.endsWith("/customer")){
            sendCustomerList(response);
        }else if(uri.endsWith("/editCustomer")){
            sendEditCustomerForm(request, response);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        int customerId = 0;
        try{
            customerId = Integer.parseInt(request.getParameter("id"));
        }catch (NumberFormatException e){}

        Customer customer = getCustomer(customerId);
        if(customer != null){
            customer.setName(request.getParameter("name"));
            customer.setCity(request.getParameter("city"));
        }
        sendCustomerList(response);
    }

}
