package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Get4", urlPatterns = "/get4")
public class Get4 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pageAsString = request.getParameter("page");

        PrintWriter writer = response.getWriter();

        if (pageAsString == null) {
            writer.println("Brak parametru page!");
        }

        int page = 0;

        try {
            page = Integer.parseInt(pageAsString);
        } catch (NumberFormatException e) {
            writer.println("Problem z parsowaniem parametru page, page = " + pageAsString);
            return;
        }

        writer.println("Dzielniki całkowite liczby " + page);
        for (int i = 1; i <= page; i++) {
            if (page % i == 0) {
                writer.println(i);
            }
        }

    }
}
