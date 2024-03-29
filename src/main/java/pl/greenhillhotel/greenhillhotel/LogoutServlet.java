package pl.greenhillhotel.greenhillhotel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet responsible for logging out the user.
 */
@WebServlet(name = "LogoutServlet", value = "/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    /**
     * Logs out the user.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        session.invalidate();

        out.println("<script type=\"text/javascript\">");
        out.println("alert('Successfully logged out!');");
        out.println("location='index.jsp';");
        out.println("</script>");

        out.close();
    }
}
