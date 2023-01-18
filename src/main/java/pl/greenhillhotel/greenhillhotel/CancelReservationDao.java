package pl.greenhillhotel.greenhillhotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Handling sql queries related to cancelling reservation.
 */
public class CancelReservationDao {
    /**
     * A method which cancels given reservation by its id.
     *
     * @param id index of the reservation you want to cancel.
     * @return result of the operation.
     */
    public String cancelReservation(int id) {
        String result = "SUCCESS";
        Connection connection = new Connector().getConnection();
        String sqlQuery = "DELETE FROM reservation WHERE id_reservation = ? ";

        try {
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            result = "Error";
        }
        return result;
    }
}
