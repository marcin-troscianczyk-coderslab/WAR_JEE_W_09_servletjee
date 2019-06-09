package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
W projekcie stwórz servlet Servlet12, dostępny pod adresem /servlet12,
Wyświetl na stronie: Content12.
Adres strony powinien być określony za pomocą odpowiedniego wpisu w deskryptorze wdrożenia
(podpowiedź znajdziesz w Snippetach).

 */

public class Servlet12 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("Content12");
    }
}
