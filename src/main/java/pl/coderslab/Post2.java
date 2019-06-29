package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Post2", urlPatterns = "/post2")
public class Post2 extends HttpServlet {

    /*
    W projekcie stwórz servlet Post2, dostępny pod adresem /post2 oraz stronę HTML index_2.html. Następnie:

Dodaj do strony formularz, wysyłany metodą POST. Formularz powinien zawierać jedno pole
tekstowe i jeden checkbox z opisem Jestem świadomy konsekwencji.
Dopisz funkcjonalność, która po przesłaniu formularza sprawdzi, czy wpisany przez użytkownika tekst zawiera wulgaryzmy.
Jeżeli tak, to nasz kod powinien zastąpić wulgarne słowo znakami. ****
Na przykład frazę cholera, znowu ta JAVA powinien zastąpić frazą *******, znów ta JAVA .
Jeżeli użytkownik zaznaczy checkbox Jestem świadomy konsekwencji, to program nie sprawdzi wulgaryzmów i
wyświetli wpisany tekst. Liczba gwiazdek ma odpowiadać liczbie znaków w cenzurowanym słowie.
     */

    private final static String[] wulgaryzmy = {"kurwa", "chuj", "dupa"};


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String text = request.getParameter("text");
        String chk = request.getParameter("chk");

        PrintWriter writer = response.getWriter();

        if ("yes".equals(chk)) {
            writer.println(text);
        } else {

            for (String wulgaryzm : wulgaryzmy) {
                String replacement = wulgaryzm.replaceAll(".", "*");
                text = text.replaceAll(wulgaryzm, replacement);
            }

            writer.println(text);
        }
    }
}
