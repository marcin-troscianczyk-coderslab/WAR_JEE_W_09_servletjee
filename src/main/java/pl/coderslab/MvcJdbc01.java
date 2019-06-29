package pl.coderslab;

import pl.coderslab.dao.BookDao;
import pl.coderslab.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MvcJdbc01", urlPatterns = "/add-book")
public class MvcJdbc01 extends HttpServlet {

    private final BookDao bookDao;

    public MvcJdbc01() {
        this.bookDao = new BookDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String isbn = request.getParameter("isbn");

        Book book = new Book(title, author, isbn);

        boolean result = bookDao.addBook(book);

        if (result) {

            List<Book> books = bookDao.findAllBooks();

            request.setAttribute("books", books);

            getServletContext().getRequestDispatcher("/WEB-INF/jdbc/result.jsp")
                    .forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/jdbc/error.jsp")
                    .forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/jdbc/add.jsp")
                .forward(request, response);

    }
}
