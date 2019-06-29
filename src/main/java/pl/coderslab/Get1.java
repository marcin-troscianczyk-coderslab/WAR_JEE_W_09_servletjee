package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Get1", urlPatterns = "/get1")
public class Get1 extends HttpServlet {

    /*
    W projekcie stwórz servlet Get1, dostępny pod adresem /get1, który pobierze z adresu dwa parametry: start i end .
Po uruchomieniu aplikacji na serwerze, w przeglądarce wyświetlą się wszystkie liczby od start do end.
(dla uproszczenia załóżmy, że będziemy przesyłać tylko liczby całkowite).
Jeżeli zmienne nie są przesłane, to strona ma wypisać informację BRAK.
Przykładowy adres wywołania: http://localhost:8080/get1?start=1&end=12;
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String startAsString = request.getParameter("start");
        String endAsString = request.getParameter("end");

        PrintWriter writer = response.getWriter();

        if (startAsString == null || endAsString == null) {
            writer.println("BRAK PARAMETRÓW");
            return;
        }

        int start = 0;
        try {
            start = Integer.parseInt(startAsString);
        } catch (NumberFormatException e) {
            writer.println("Problem z parsowaniem parametru start! Parametr start = " + startAsString);
            return;
        }

        int end = 0;
        try {
            end = Integer.parseInt(endAsString);
        } catch (NumberFormatException e) {
            writer.println("Problem z parsowaniem parametru end! Parametr end = " + endAsString);
            return;
        }

        for (int i = start; i <= end; i++) {
            // piszemy do writera
            writer.println(i);
        }
    }
}
