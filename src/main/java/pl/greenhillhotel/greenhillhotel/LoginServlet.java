package pl.greenhillhotel.greenhillhotel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginBean userLoginData = new LoginBean(request.getParameter("mail"), request.getParameter("password"));
        UserBean userData = new LoginDao().login(userLoginData);
        PrintWriter out = response.getWriter();

        if (!userData.isValid()) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('User not found! Try registering first.');");
            out.println("location='login.jsp';");
            out.println("</script>");
        }
        else {
            HttpSession session = request.getSession(true);
            session.setAttribute("currentUser", userData);
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Successfully logged in!');");
            out.println("location='index.jsp';");
            out.println("</script>");
        }
        out.close();
    }
}
