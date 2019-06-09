package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

@WebServlet(urlPatterns = "/servlet13")
public class Servlet13 extends HttpServlet {

    private static final DateTimeFormatter FORMATTER =
            new DateTimeFormatterBuilder().appendPattern("HH:mm:ss").toFormatter();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LocalTime time = LocalTime.now();
        response.getWriter().println(time.format(FORMATTER));
    }
}
