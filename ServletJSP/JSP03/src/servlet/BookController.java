package servlet;

import model.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/books"})
public class BookController extends HttpServlet {
    private static final int serialVersionUID = -234237;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        ArrayList<Book> books = new ArrayList<>();
        Book book1 = new Book("123-456789", "Java 7", 45.00);
        Book book2 = new Book("789-456132", "Java 8", 58.00);
        Book book3 = new Book("456-789132", "Java 9", 72.00);

        books.add(book1);
        books.add(book2);
        books.add(book3);

        request.setAttribute("books",  books);
        RequestDispatcher rd = request.getRequestDispatcher("/books.jsp");
        rd.forward(request, response);



    }


}
