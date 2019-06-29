package pl.coderslab;

import pl.coderslab.dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MvcJdbc02", urlPatterns = "/delete-book")
public class MvcJdbc02 extends HttpServlet {

    private final BookDao bookDao;

    public MvcJdbc02() {
        this.bookDao = new BookDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idAsString = request.getParameter("id");

        try {
            int id = Integer.parseInt(idAsString);
            bookDao.deleteById(id);
        } catch (NumberFormatException e) {

        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String idAsString = request.getParameter("id");

        try {
            int id = Integer.parseInt(idAsString);
            bookDao.deleteById(id);
        } catch (NumberFormatException e) {

        }
    }
}
