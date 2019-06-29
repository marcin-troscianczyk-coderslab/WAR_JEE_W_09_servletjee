package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Mvc11", urlPatterns = "/mvc11")
public class Mvc11 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String role = request.getParameter("role");

        if (role == null) {
            request.setAttribute("role", "guest");
        } else {
            request.setAttribute("role", role);
        }

        getServletContext().getRequestDispatcher("/WEB-INF/jsp1.jsp")
                .forward(request, response);
    }
}
