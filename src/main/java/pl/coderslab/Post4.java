package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "Post4", urlPatterns = "/post4")
public class Post4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String[] numbersAsString = request.getParameterValues("numbers");

        List<Integer> numbers = new ArrayList<>();

        for (String numberAsString: numbersAsString) {

            try {
                int number = Integer.parseInt(numberAsString);
                numbers.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Parametr nie reprezentuje wartości liczbowej number = " + numberAsString);
            }
        }

        Collections.sort(numbers);

        PrintWriter writer = response.getWriter();
        for (Integer number : numbers) {
            writer.println(number);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();

        StringJoiner joiner =
                new StringJoiner("",
                        "<!DOCTYPE html>" +
                                "<html lang=\"en\">" +
                                "<head>" +
                                "    <meta charset=\"UTF-8\">" +
                                "    <title>Title</title>" +
                                "</head>" +
                                "<body>" +
                                "    <form action=\"/post4\" method=\"post\">",



                          "    <input type=\"submit\" value=\"Wyślij\">" +
                                  " </form>\n" +
                                  "</body>" +
                                  "</html>");


        Random random = new Random();
        int couner = 5 + random.nextInt(6);

        for (int i = 0; i < couner; i++) {
            joiner.add("<input name='numbers'/><br/>");
        }
        writer.println(joiner.toString());
    }
}
