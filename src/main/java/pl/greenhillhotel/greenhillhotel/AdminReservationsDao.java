package pl.greenhillhotel.greenhillhotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminReservationsDao {
    public List<ReservationBean> getReservations() {
        Connection connection = new Connector().getConnection();
        String sqlQuery = "SELECT * FROM reservation";
        String sqlQueryUser = "SELECT name, surname FROM user WHERE id_registration= ? ";
        List <ReservationBean> list = new ArrayList<>();
        try {
            ResultSet rs = connection.createStatement().executeQuery(sqlQuery);
            if (rs == null)
                return null;
            else {
                while (rs.next()) {
                    PreparedStatement ps = connection.prepareStatement(sqlQueryUser);
                    int idReservation = rs.getInt("id_reservation");
                    int idRoom = rs.getInt("id_room");
                    int idUser = rs.getInt("id_user");
                    ps.setInt(1, idUser);
                    String bedConfig = rs.getString("bed_config");
                    boolean tv = rs.getBoolean("tv");
                    String accommodation = rs.getString("date_start");
                    String checkout = rs.getString("date_end");

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        Date today = dateFormat.parse(LocalDate.now().toString());
                        Date checkoutDate = dateFormat.parse(checkout);
                        if (checkoutDate.compareTo(today) <= 0) {
                            continue;
                        }

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    ReservationBean reservation = new ReservationBean(idRoom, idUser, bedConfig, tv, accommodation, checkout);
                    ResultSet rsUser = ps.executeQuery();
                    rsUser.next();
                    reservation.setId_reservation(idReservation);
                    reservation.setName(rsUser.getString("name"));
                    reservation.setSurname(rsUser.getString("surname"));
                    list.add(reservation);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
