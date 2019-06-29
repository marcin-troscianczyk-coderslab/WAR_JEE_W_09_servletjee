package pl.coderslab;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Mvc12", urlPatterns = "/mvc12")
public class Mvc12 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String startAsString = request.getParameter("start");
        String endAsString = request.getParameter("end");

        int start = 10;
        try {
            start = Integer.parseInt(startAsString);
        } catch (NumberFormatException e) {
            System.out.println("Nie mogę sparsować parametru start, start = " + startAsString);
        }

        int end = 20;
        try {
            end = Integer.parseInt(endAsString);
        } catch (NumberFormatException e) {
            System.out.println("Nie mogę sparsować parametru end, end = " + endAsString);
        }

        request.setAttribute("start", start + 10);
        request.setAttribute("end", end + 10);

        List<Integer> numbers = new ArrayList<>();

        for (int i = start + 10; i <= end + 10; i++) {
            numbers.add(i);
        }

        HttpSession session = request.getSession();

        session.setAttribute("numbers", numbers);

        getServletContext().getRequestDispatcher("/WEB-INF/jsp2.jsp")
                .forward(request, response);
    }
}
