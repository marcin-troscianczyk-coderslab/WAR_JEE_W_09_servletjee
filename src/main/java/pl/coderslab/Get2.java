package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

@WebServlet(name = "Get2", urlPatterns = "/get2")
public class Get2 extends HttpServlet {

    /*
    W projekcie stwórz servlet Get2, dostępny pod adresem /get2,
    który wyświetli listę przesłanych w zapytaniu (request) parametrów i ich wartość
    (niezależnie od liczby przesłanych parametrów). Wykorzystaj poniższy kod:
 Map<String, String[]> parameterMap = request.getParameterMap();
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String[]> parameters = request.getParameterMap();

        PrintWriter writer = response.getWriter();

        if (parameters.isEmpty()) {
            writer.println("Brak parametrów.");
            return;
        }


        for (String key : parameters.keySet()) {

            String[] value = parameters.get(key);
            writer.println("Parameter name: " + key + ", value: " + Arrays.toString(value));
        }
        /*for (Map.Entry<String, String[]> entry : parameters.entrySet()) {

            String paramName = entry.getKey();
            String[] paramValues = entry.getValue();

            writer.println("Parameter name: " + paramName + ", value: " + Arrays.toString(paramValues));

        }*/
    }
}
