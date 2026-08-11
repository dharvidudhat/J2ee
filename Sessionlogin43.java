package pkg;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Check login
        if (username.equals("admin") && password.equals("1234")) {

            // Create session
            HttpSession session = request.getSession();

            // Store username in session
            session.setAttribute("username", username);

            out.println("<html>");
            out.println("<body>");

            out.println("<h1>Welcome, " + username + "!</h1>");
            out.println("<h2>You are successfully logged in.</h2>");

            out.println("</body>");
            out.println("</html>");

        } else {

            out.println("<html>");
            out.println("<body>");

            out.println("<h2>Invalid Username or Password</h2>");
            out.println("<a href='login.html'>Login Again</a>");

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
}
