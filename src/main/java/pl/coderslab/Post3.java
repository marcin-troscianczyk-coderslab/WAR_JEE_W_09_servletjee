package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Post3", urlPatterns = "/post3")
public class Post3 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String aAsString = request.getParameter("a");
        String bAsString = request.getParameter("b");
        String cAsString = request.getParameter("c");

        // walidacja a, b, c

        int a = 0;

        try {
            a = Integer.parseInt(aAsString);
        } catch (NumberFormatException e) {
            System.out.println("Nie udało się sparsować parametru a a = " + aAsString);
        }

        int b = 0;

        try {
            b = Integer.parseInt(bAsString);
        } catch (NumberFormatException e) {
            System.out.println("Nie udało się sparsować parametru b b = " + bAsString);
        }

        int c = 0;

        try {
            c = Integer.parseInt(cAsString);
        } catch (NumberFormatException e) {
            System.out.println("Nie udało się sparsować parametru c c = " + cAsString);
        }

        int delta = b * b - 4 * a * c;

        PrintWriter writer = response.getWriter();

        if (delta < 0) {
            writer.println("Równanie nie posiada pierwistków a = " + a + ", b = " + b + ", c = " + c);
        } else if (delta == 0) {
            float x = -((float) b) / (2 * a);
            writer.println("Równanie posiada jeden podwójny pierwistek x = " + x + " a = " + a + ", b = " + b + ", c = " + c);
        } else {
            float x1 = -(((float) b) + (float) Math.sqrt(delta))/ (2 * a);
            float x2 = -(((float) b) - (float) Math.sqrt(delta))/ (2 * a);
            writer.println("Równanie posiada dwa pierwistki x1 = " + x1 + ", x2 = " + x2 + " a = " + a + ", b = " + b + ", c = " + c);
        }

    }
}
