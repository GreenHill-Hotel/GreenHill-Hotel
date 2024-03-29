package pl.greenhillhotel.greenhillhotel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet responsible for preparing data to show for a page administrator.
 */
@WebServlet(name = "AdminReservationsServlet", value = "/AdminReservationsServlet")
public class AdminReservationsServlet extends HttpServlet {
    /**
     * Prepares the reservations data to be displayed.
     *
     * @see AdminReservationsDao
     * @see ReservationBean
     **/
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ReservationBean> reservations = new AdminReservationsDao().getReservations();
        PrintWriter out = response.getWriter();

        if (reservations == null || reservations.size() == 0) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('No reservations to show yet!');");
            out.println("location='index.jsp';");
            out.println("</script>");
        }

        else {
            request.setAttribute("adminReservations", reservations);
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        }
    }
}
