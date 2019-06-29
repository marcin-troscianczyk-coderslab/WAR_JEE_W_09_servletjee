package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Cookie1Del", urlPatterns = "/deleteCookie")
public class Cookie1Del extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();

        PrintWriter writer = response.getWriter();

        for(Cookie cookie : cookies) {
            String cookieName = cookie.getName();
            if ("User".equals(cookieName)) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                return;
            }
        }

        writer.println("Nie znaleziono cookie User.");
    }
}
