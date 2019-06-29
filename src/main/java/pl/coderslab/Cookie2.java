package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Cookie2", urlPatterns = "/addToCookie")
public class Cookie2 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cookieName = request.getParameter("key");
        String cookieValue = request.getParameter("value");

        // walidacja

        PrintWriter writer = response.getWriter();
        Cookie cookie = new Cookie(cookieName, cookieValue);
        response.addCookie(cookie);

    }
}
