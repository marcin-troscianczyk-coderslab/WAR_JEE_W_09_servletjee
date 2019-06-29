package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cookie1Set", urlPatterns = "/setCookie")
public class Cookie1Set extends HttpServlet {

    /*
    W projekcie stwórz trzy servlety Cookie1Set, Cookie1Get, Cookie1Del. Następnie:

Servlet Cookie1Set ma być dostępny pod adresem /setCookie. Ma nastawiać ciasteczko o nazwie User na Coders Lab, z ważnością 24h.
Servlet Cookie1Get ma być dostępny pod adresem /showCookie. Ma wyświetlać zawartość ciasteczka User. Jeżeli nie ma takiego ciasteczka, to powinna się wyświetlić odpowiednia informacje.
Servlet Cookie1Del ma być dostępny pod adresem /deleteCookie ma kasować ciasteczko o nazwie User. Jeżeli nie ma takiego ciasteczka, to powinna się wyświetlić odpowiednia informacje.
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie cookie = new Cookie("User", "Coders_Lab");
        cookie.setMaxAge(24 * 60 * 60);

        response.addCookie(cookie);

    }
}
