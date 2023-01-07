package pl.greenhillhotel.greenhillhotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CancelReservationDao {
    public String cancelReservation(int id) {
        String result = "SUCCESS";
        Connection connection = new Connector().getConnection();
        String sqlQuery = "DELETE FROM reservation WHERE id_reservation = ? ";

        try {
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            ps.setString(1, Integer.toString(id));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            result = "Error";
        }
        return result;
    }
}
