package pl.coderslab;

import pl.coderslab.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Mvc14", urlPatterns = "/mvc14")
public class Mvc14 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        List<Book> books = new ArrayList<>(5);

        for (int index = 1; index <= 5; index++) {
            String title = request.getParameter("title" + index);
            String author = request.getParameter("author" + index);
            String isbn = request.getParameter("isbn" + index);

            if (!"".equals(title) && !"".equals(author) && !"".equals(isbn)) {

                Book book = new Book(title, author, isbn);
                books.add(book);
            }

        }

        request.setAttribute("books", books);

        getServletContext().getRequestDispatcher("/WEB-INF/book/list.jsp")
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/book/form.jsp")
                .forward(request, response);
    }
}
