package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Get5", urlPatterns = "/get5")
public class Get5 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String company = request.getParameter("company");
        String[] languages = request.getParameterValues("learn");

        PrintWriter writer = response.getWriter();

        writer.println("company:");
        writer.println("\t - " + company);
        writer.println("learn:");

        for (String language : languages) {
            writer.println("\t - " + language);
        }

    }
}
