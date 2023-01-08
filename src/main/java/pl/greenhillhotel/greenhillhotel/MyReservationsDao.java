package pl.greenhillhotel.greenhillhotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MyReservationsDao {
    public List<ReservationBean> getReservations(int idUser) {
        Connection connection = new Connector().getConnection();
        String sqlQuery = "SELECT * FROM reservation WHERE id_user= ? ";
        List <ReservationBean> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            ps.setInt(1, idUser);
            ResultSet rs = ps.executeQuery();
            if (rs == null)
                return null;
            else {
                while (rs.next()) {
                    int idReservation = rs.getInt("id_reservation");
                    int idRoom = rs.getInt("id_room");
                    String bedConfig = rs.getString("bed_config");
                    boolean tv = rs.getBoolean("tv");
                    String accommodation = rs.getString("date_start");
                    String checkout = rs.getString("date_end");
                    boolean cancelable = true;

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        Date today = dateFormat.parse(LocalDate.now().toString());
                        Calendar c= Calendar.getInstance();
                        c.setTime(today);
                        c.add(Calendar.DATE, 7);
                        Date plusWeek = c.getTime();
                        Date checkoutDate = dateFormat.parse(checkout);
                        Date accommodationDate = dateFormat.parse(accommodation);
                        System.out.println(plusWeek);
                        if (checkoutDate.compareTo(today) <= 0) {
                            continue;
                        }
                        cancelable = plusWeek.compareTo(accommodationDate) <= 0;

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    ReservationBean reservation = new ReservationBean(idRoom, idUser, bedConfig, tv, accommodation, checkout);
                    reservation.setId_reservation(idReservation);
                    reservation.setCancelable(cancelable);
                    System.out.println(cancelable);
                    list.add(reservation);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
