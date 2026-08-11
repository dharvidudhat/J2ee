import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "VisitCountServlet", urlPatterns = {"/VisitCountServlet"})
public class VisitCountServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            // Create or get existing session
            HttpSession session = request.getSession();

            // Get visit count from session
            Integer count = (Integer) session.getAttribute("visitCount");

            // If first visit
            if (count == null) {
                count = 1;
            } else {
                count++;
            }

            // Store updated count in session
            session.setAttribute("visitCount", count);

            // Display output
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Visit Counter</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<h1>Welcome!</h1>");
            out.println("<h2>You have visited this page "
                    + count + " times during this session.</h2>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet that counts page visits during a session";
    }
}
