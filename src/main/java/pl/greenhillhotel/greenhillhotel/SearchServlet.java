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
        Integer people = Integer.parseInt(request.getParameter("people"));
        boolean is_checked = request.getParameter("balcony") != null;
        PrintWriter out = response.getWriter();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date today = dateFormat.parse(LocalDate.now().toString());
            Date accommodationDate = dateFormat.parse(accommodation);
            Date checkoutDate = dateFormat.parse(checkout);

            if (today.compareTo(accommodationDate) < 0 || accommodationDate.compareTo(checkoutDate) <= 0) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Wrong date entered!');");
                out.println("location='index.jsp';");
                out.println("</script>");
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (people <= 0 || people > 3) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Wrong people count!');");
            out.println("location='index.jsp';");
            out.println("</script>");
        }
    }
}
