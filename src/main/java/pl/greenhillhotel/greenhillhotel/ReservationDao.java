package pl.greenhillhotel.greenhillhotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReservationDao {
    public String insert(ReservationBean reservationData) {
        Connection connection = new Connector().getConnection();
        String sqlQuery = "INSERT INTO reservation (id_room, id_user, bed_config, tv, date_start, date_end) VALUES (?, ?, ?, ?, ?, ?)";
        String result = "SUCCESS";
        try {
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            ps.setString(1, Integer.toString(reservationData.getId_room()));
            ps.setString(2, Integer.toString(reservationData.getId_user()));
            ps.setString(3, reservationData.getBed_config());
            ps.setString(4, Boolean.toString(reservationData.isTv()));
            ps.setString(5, reservationData.getAccommodation());
            ps.setString(6, reservationData.getCheckout());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            result = "Error";
        }
        return result;
    }
}
