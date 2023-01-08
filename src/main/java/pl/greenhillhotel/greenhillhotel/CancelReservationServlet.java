package pl.greenhillhotel.greenhillhotel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CancelReservationServlet", value = "/CancelReservationServlet")
public class CancelReservationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("cancel"));
        PrintWriter out = response.getWriter();

        String result = new CancelReservationDao().cancelReservation(id);

        if (result.equals("SUCCESS")) {
            request.getRequestDispatcher("AdminReservationsServlet").forward(request, response);
        }
        else {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('We couldn't cancel this reservation! Try again later.');");
            out.println("location='index.jsp';");
            out.println("</script>");
        }
    }
}
