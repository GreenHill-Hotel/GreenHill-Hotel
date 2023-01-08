package pl.greenhillhotel.greenhillhotel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ReservationServlet", value = "/ReservationServlet")
public class ReservationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        AvailableRoom availableRoom = (AvailableRoom) session.getAttribute("availableRoom");
        String bedConfig = request.getParameter("bed-set");
        boolean tv = Boolean.parseBoolean(request.getParameter("tv"));
        UserBean user = (UserBean) session.getAttribute("currentUser");
        PrintWriter out = response.getWriter();

        if (user == null) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('You have to log in first!');");
            out.println("location='index.jsp';");
            out.println("</script>");
        }
        else {
            ReservationBean reservationBean = new ReservationBean(
                    availableRoom.getId_room(),
                    user.getId(),
                    bedConfig,
                    tv,
                    availableRoom.getAccommodation(),
                    availableRoom.getCheckout()
            );
            String result = new ReservationDao().insert(reservationBean);
            if (result.equals("SUCCESS")) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Successfully reserved the room!');");
                out.println("location='index.jsp';");
                out.println("</script>");
            }
            else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('We couldn't reserve your room, please try again later.');");
                out.println("location='index.jsp';");
                out.println("</script>");
            }
        }
    }
}
