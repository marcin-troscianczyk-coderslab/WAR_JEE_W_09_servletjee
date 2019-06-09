package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
Stwórz projekt a w nim servlet Servlet11, dostępny pod adresem /servlet11, który wyświetli na konsoli "Hello First Servlet",
jednocześnie wyświetli w przeglądarce Content11.
Adres strony powinien być określony za pomocą adnotacji.
Skonfiguruj IntelliJ wraz z serwerem Tomcat.
Uruchom projekt.
 */

@WebServlet(urlPatterns = "/dupa")
public class Servlet11 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello First Servlet");
        resp.getWriter().println("Content11");
    }

}
