package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Sess01Get", urlPatterns = "/sess01Get")
public class Sess01Get extends HttpServlet {
       /*
    W projekcie stwórz trzy servlety:

Sess01Set dostępny pod adresem /sess01Set,
Sess01Get dostępny pod adresem /sess01Get ,
Sess01Del dostępny pod adresem /sess01Del.
Pierwszy ma nastawiać informacje w sesji pod kluczem counter na 0.
Drugi ma wyświetlać zawartość sesji pod kluczem counter i zwiększać ją o 1. Jeżeli nie ma takich danych w sesji,
to strona powinna wyświetlić informację: EMPTY.
Trzeci ma usuwać dane z sesji (tylko te trzymane pod kluczem counter).
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        Object obj = session.getAttribute("counter");

        PrintWriter writer = response.getWriter();

        if (obj instanceof Integer) {
            Integer counter = (Integer) obj;
            session.setAttribute("counter", counter + 1);
            writer.println("Counter: " + counter);
        } else {
            writer.println("EMPTY");
        }

    }
}
