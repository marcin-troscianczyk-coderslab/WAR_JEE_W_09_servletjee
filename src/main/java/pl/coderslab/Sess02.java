package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Sess02", urlPatterns = "/sess02")
public class Sess02 extends HttpServlet {

    /*
    W projekcie stwórz servlet Sess02 dostępny pod adresem /sess02.

W metodzie doGet wyświetl formularz z możliwością wpisania oceny.
Po zatwierdzeniu formularza dodaj ocenę do sesji. Oceny trzymaj w liście, którą będziesz wkładać do sesji.
Wylicz średnią z ocen (pamiętaj o właśnie dodanej ocenie).
Wszystkie zapamiętane oceny i ich średnia powinny być wyświetlane po zatwierdzeniu formularza.
     */

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String dupaAsString = request.getParameter("note");

        PrintWriter writer = response.getWriter();

        int dupa = 0;

        try {
            dupa = Integer.parseInt(dupaAsString);
        } catch (NumberFormatException e) {
            writer.println("Nie można sparsować oceny, ocena " + dupaAsString);
            return;
        }

        HttpSession session = request.getSession();

        Object obj = session.getAttribute("dupa");

        if (obj instanceof List) {
            List<Integer> notes = (List) obj;
            notes.add(dupa);

            int sum = 0;
            for (Integer note : notes) {
                sum += note;
            }

            float avg = ((float) sum) / notes.size();

            writer.println("Średnia ocen: " + avg);

            writer.println("Oceny:");
            for(Integer note : notes) {
                writer.println(note);
            }
        } else {
            List<Integer> notes = new ArrayList<>();
            notes.add(dupa);
            session.setAttribute("dupa", notes);
            writer.println("Średnia ocen: " + dupa);
            writer.println("Oceny:");
            writer.println(dupa);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String html =
                "<form action=\"/sess02\" method=\"post\">" +
                        "<input type=\"number\" name=\"note\">" +
                        "<input type=\"submit\"/>" +
                "</form>";

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println(html);

    }
}
