import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ColorServlet", urlPatterns = {"/ColorServlet"})
public class ColorServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            // Get session
            HttpSession session = request.getSession();

            // Get selected color
            String color = request.getParameter("color");

            // Save color in session
            session.setAttribute("bgcolor", color);

            // Apply selected color
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Background Color</title>");
            out.println("</head>");

            out.println("<body style='background-color:" + color + ";'>");

            out.println("<h1>Background Color Changed!</h1>");
            out.println("<h2>Selected Color: " + color + "</h2>");

            out.println("<br>");
            out.println("<a href='index.html'>Change Color</a>");

            out.println("</body>");
            out.println("</html>");
        }
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

    @Override
    public String getServletInfo() {
        return "Servlet for selecting and storing background color in session";
    }
}
