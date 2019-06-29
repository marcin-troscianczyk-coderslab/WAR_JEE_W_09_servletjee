package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Post1", urlPatterns = "/post1")
public class Post1 extends HttpServlet {

    /*
    W projekcie stwórz servlet Post1 , dostępny pod adresem /post1 oraz stronę HTML index_1.html,
    w której zawarty jest formularz przesyłający imię i nazwisko.
    Po uruchomieniu na serwerze i uzupełnieniu formularza w przeglądarce wyświetli się napis:
    Witaj, <podane imię> <podane nazwisko>.
     */

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        PrintWriter writer = response.getWriter();

        writer.println("Witaj, " + name + " " + surname);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
