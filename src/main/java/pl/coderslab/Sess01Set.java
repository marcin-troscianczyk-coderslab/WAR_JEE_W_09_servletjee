package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Sess01Set", urlPatterns = "/sess01Set")
public class Sess01Set extends HttpServlet {

    /*
    W projekcie stwórz trzy servlety:

Sess01Set dostępny pod adresem /sess01Set,
Sess01Get dostępny pod adresem /sess01Get ,
Sess01Del dostępny pod adresem /sess01Del.
Pierwszy ma nastawiać informacje w sesji pod kluczem counter na 0.
Drugi ma wyświetlać zawartość sesji pod kluczem counter i zwiększać ją o 1. Jeżeli nie ma takich danych w sesji, to strona powinna wyświetlić informację: EMPTY.
Trzeci ma usuwać dane z sesji (tylko te trzymane pod kluczem counter).
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        session.setAttribute("counter", 0);

    }
}
