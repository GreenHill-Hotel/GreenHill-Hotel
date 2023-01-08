package pl.greenhillhotel.greenhillhotel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "MyReservationsServlet", value = "/MyReservationsServlet")
public class MyReservationsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserBean user = (UserBean) session.getAttribute("currentUser");
        int idUSer = user.getId();

        List<ReservationBean> reservations = new MyReservationsDao().getReservations(idUSer);
        PrintWriter out = response.getWriter();

        if (reservations == null || reservations.size() == 0) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('No reservations to show yet!');");
            out.println("location='index.jsp';");
            out.println("</script>");
        }

        else {
            request.setAttribute("myReservations", reservations);
            request.getRequestDispatcher("myreservations.jsp").forward(request, response);
        }

    }
}
