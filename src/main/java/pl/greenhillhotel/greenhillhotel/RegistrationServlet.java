package pl.greenhillhotel.greenhillhotel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet", value = "/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String email = request.getParameter("mail");
        String password = request.getParameter("password");

        RegisterBean member = new RegisterBean(name, last_name, email, password);

        RegisterDao registerDao = new RegisterDao();
        String result = registerDao.insert(member);
        if (result.equals("SUCCESS")) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        else {
            request.setAttribute("errMessage", result);
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }
}
