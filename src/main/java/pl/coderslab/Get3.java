package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Get3", urlPatterns = "/get3")
public class Get3 extends HttpServlet {

    /*
    W projekcie stwórz servlet Get3, dostępny pod adresem /get3, który ma pobierać dwie zmienne o nazwach width i height. Jeżeli informacje nie są przesłane to width = 5 i height = 10.
Następnie wygeneruj tabliczkę mnożenia o podanej wysokości i szerokości i wyświetl ją w przeglądarce.
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String widthAsString = request.getParameter("width");
        String heightAsString = request.getParameter("height");

        int width = 5;
        try {
            width = Integer.parseInt(widthAsString);
        } catch (NumberFormatException e) {
            System.out.println("Problem z parsowaniem parametru width: " + widthAsString);
        }

        int height = 10;
        try {
            height = Integer.parseInt(heightAsString);
        } catch (NumberFormatException e) {
            System.out.println("Problem z parsowaniem parametru height: " + heightAsString);
        }

        PrintWriter writer = response.getWriter();

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                writer.print(String.format("%2d ", i * j));
            }
            writer.println();
        }

    }
}
