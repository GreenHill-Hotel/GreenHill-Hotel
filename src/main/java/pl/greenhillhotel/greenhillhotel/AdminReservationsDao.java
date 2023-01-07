package pl.greenhillhotel.greenhillhotel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminReservationsDao {
    public List<ReservationBean> getReservations() {
        Connection connection = new Connector().getConnection();
        String sqlQuery = "SELECT * FROM reservation";
        List <ReservationBean> list = new ArrayList<>();
        try {
            ResultSet rs = connection.createStatement().executeQuery(sqlQuery);
            if (!rs.next())
                return null;
            else {
                while (rs.next()) {
                    int idReservation = rs.getInt("id_reservation");
                    int idRoom = rs.getInt("id_room");
                    int idUser = rs.getInt("id_user");
                    String bedConfig = rs.getString("bed_config");
                    boolean tv = rs.getBoolean("tv");
                    String accommodation = rs.getString("date_start");
                    String checkout = rs.getString("date_end");
                    ReservationBean reservation = new ReservationBean(idRoom, idUser, bedConfig, tv, accommodation, checkout);
                    reservation.setId_reservation(idReservation);
                    list.add(reservation);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
