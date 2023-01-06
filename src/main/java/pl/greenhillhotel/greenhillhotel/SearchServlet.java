package pl.greenhillhotel.greenhillhotel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@WebServlet(name = "SearchServlet", value = "/SearchServlet")
public class SearchServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accommodation = request.getParameter("accommodation");
        String checkout = request.getParameter("checkout");
        int people = Integer.parseInt(request.getParameter("people"));
        boolean is_checked = request.getParameter("balcony") != null;
        PrintWriter out = response.getWriter();
        boolean success = true;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date today = dateFormat.parse(LocalDate.now().toString());
            Date accommodationDate = dateFormat.parse(accommodation);
            Date checkoutDate = dateFormat.parse(checkout);

            if (accommodationDate.compareTo(today) < 0 || checkoutDate.compareTo(accommodationDate) <= 0) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Wrong date entered!');");
                out.println("location='index.jsp';");
                out.println("</script>");
                success = false;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (people <= 0 || people > 3) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Wrong people count!');");
            out.println("location='index.jsp';");
            out.println("</script>");
            success = false;
        }

        if (success) {
            SearchBean room = new SearchBean(accommodation, checkout, people, is_checked);
            SearchDao searchDao = new SearchDao();
            int roomNumber = searchDao.getRoom(room);

            AvailableRoom availableRoom = new AvailableRoom(accommodation, checkout, people, is_checked, roomNumber);
            request.setAttribute("availableRoom", availableRoom);
            request.getRequestDispatcher("room.jsp").forward(request, response);
        }
    }
}
