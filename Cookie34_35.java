import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();
        boolean usernameCookieFound = false;

        // Check if username cookie already exists
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    usernameCookieFound = true;
                    break;
                }
            }
        }

        // If username cookie does not exist, create it
        if (!usernameCookieFound) {

            Cookie newCookie = new Cookie("username", "Dharvi");

            // Maximum age = 1 day = 24 * 60 * 60 seconds
            newCookie.setMaxAge(24 * 60 * 60);

            response.addCookie(newCookie);

            out.println("<h3>New cookie created successfully.</h3>");
        } else {
            out.println("<h3>Username cookie already exists.</h3>");
        }

        // Display all cookies
        out.println("<h2>Cookies Sent by Browser</h2>");

        if (cookies != null && cookies.length > 0) {

            for (Cookie cookie : cookies) {
                out.println("Cookie Name: " + cookie.getName() + "<br>");
                out.println("Cookie Value: " + cookie.getValue() + "<br><br>");
            }

        } else {
            out.println("<p>No cookies were sent by the browser.</p>");
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
