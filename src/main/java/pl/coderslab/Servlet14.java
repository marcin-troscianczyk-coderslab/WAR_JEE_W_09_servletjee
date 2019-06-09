package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/servlet14")
public class Servlet14 extends HttpServlet {

    /*
    W projekcie stwórz servlet Servlet14 dostępny pod adresem /servlet14,
Wyświetl w przeglądarce poniższe informacje (wykorzystaj metodę getHeader obiektu typu HttpServletRequest):
Adres IP
Przeglądarkę
Aktualny czas (wykorzystaj LocalTime.now() )
     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final Enumeration<String> headerNames = request.getHeaderNames();

        PrintWriter writer = response.getWriter();

        while (headerNames.hasMoreElements()) {
             final String headerName = headerNames.nextElement();
             final String headerValue = request.getHeader(headerName);
             writer.println("Header " + headerName + " : " + headerValue);
         }

        String remoteAddr = request.getRemoteAddr();
        String remoteHost = request.getRemoteHost();
        int remotePort = request.getRemotePort();

        writer.println("Remote Addr: " + remoteAddr + ", remote host: " + remoteHost + ", remote port: " + remotePort);

        LocalTime time = LocalTime.now();
        writer.println("Local time: " + time);
    }
}
