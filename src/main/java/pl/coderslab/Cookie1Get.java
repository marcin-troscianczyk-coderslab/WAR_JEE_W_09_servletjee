package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Cookie1Get", urlPatterns = "/showCookie")
public class Cookie1Get extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();

        PrintWriter writer = response.getWriter();

        for (Cookie cookie : cookies) {
            String cookieName = cookie.getName();
            if ("User".equals(cookieName)) {
                writer.println("Cookie User: " + cookie.getValue() + ", maxAge: " + cookie.getMaxAge());
                return;
            }
        }

        writer.println("Nie znaleziono cookie User.");
    }
}
