package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Post5", urlPatterns = "/post5")
public class Post5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String degreesAsString = request.getParameter("degrees");

        PrintWriter writer = response.getWriter();

        float degrees = 0.0f;
        try {
            degrees = Float.parseFloat(degreesAsString);
        } catch (NumberFormatException e) {
            writer.println("Problem z parsowaniem temperatury " + degreesAsString);
            return;
        }

        String convertionType = request.getParameter("convertionType");

        if ("celcToFahr".equals(convertionType)) {
            float tf = 32 + ((float) 9/5) * degrees;
            writer.println("Temperatura w stopniach Fahrenheita: " + tf);
        } else {
            float tc = ((float) 5/9) * (degrees - 32);
            writer.println("Temperatura w stopniach Celsjusza: " + tc);
        }
    }


}
