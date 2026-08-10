package pkg;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ColorServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        String color = request.getParameter("color");

        // Create cookie
        Cookie c = new Cookie("bgcolor", color);

        // Cookie valid for 1 day
        c.setMaxAge(24 * 60 * 60);

        // Add cookie to response
        response.addCookie(c);

        // Display selected color
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Background Color</title>");
        out.println("</head>");

        out.println("<body style='background-color:" + color + "'>");

        out.println("<h1>Background Color Applied</h1>");
        out.println("<h2>Selected Color: " + color + "</h2>");

        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }
}
