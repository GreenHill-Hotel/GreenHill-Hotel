package pl.greenhillhotel.greenhillhotel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegistrationServlet", value = "/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String email = request.getParameter("mail");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();

        RegisterBean member = new RegisterBean(name, last_name, email, password);

        RegisterDao registerDao = new RegisterDao();
        String result = registerDao.insert(member);
        if (result.equals("SUCCESS")) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Successfully registered!');");
            out.println("location='index.jsp';");
            out.println("</script>");
        }
        else if (result.equals("Account with such email already exists.")) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Account with such email already exists.');");
            out.println("location='register.jsp';");
            out.println("</script>");
        }
        else {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Failed to register you!');");
            out.println("location='register.jsp';");
            out.println("</script>");
        }
        out.close();
    }
}