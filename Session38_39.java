package pkg;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        // Get existing session or create new session
        HttpSession session = request.getSession();

        // Get name from form
        String name = request.getParameter("username");

        // Check whether name is already stored in session
        String oldName = (String) session.getAttribute("username");

        if (oldName == null) {

            // First visit
            if (name != null && !name.equals("")) {

                session.setAttribute("username", name);

                out.println("<h1>Welcome " + name + "</h1>");
            } else {

                out.println("<h1>Welcome</h1>");
            }

        } else {

            // User has visited before
            out.println("<h1>Welcome back " + oldName + "</h1>");
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
