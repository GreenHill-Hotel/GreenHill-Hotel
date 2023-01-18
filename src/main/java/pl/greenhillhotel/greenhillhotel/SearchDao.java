package pl.greenhillhotel.greenhillhotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Handling sql queries related to searching for the desired available room.
 *
 * @see SearchBean
 */
public class SearchDao {
    /**
     * Method to get the first available room which meets expectations.
     *
     * @param roomInfo object with all essential room data
     * @return id of the proper room.
     * @see SearchBean
     */
    public Integer getRoom(SearchBean roomInfo) {
        Connection connection = new Connector().getConnection();
        String getRoomsQuery = "SELECT id_room FROM room WHERE capacity= ? AND balcony= ? ";
        String getReservedRoomsQuery = "SELECT id_room FROM reservation WHERE DATE( ? ) < date_end AND DATE( ? ) > date_start ";

        List<Integer> roomList = new ArrayList<>();
        List<Integer> reservationList = new ArrayList<>();

        int availableRoomNumber = 0;

        try {
            PreparedStatement psGetRoom = connection.prepareStatement(getRoomsQuery);
            psGetRoom.setInt(1, roomInfo.getPeople());
            psGetRoom.setBoolean(2, roomInfo.isBalcony());
            ResultSet rsRooms = psGetRoom.executeQuery();

            PreparedStatement psGetReservations = connection.prepareStatement(getReservedRoomsQuery);
            psGetReservations.setString(1, roomInfo.getAccommodation());
            psGetReservations.setString(2, roomInfo.getCheckout());
            ResultSet rsReservations = psGetReservations.executeQuery();

            while (rsRooms.next()) {
                roomList.add(rsRooms.getInt("id_room"));
            }


            while (rsReservations.next()) {
                reservationList.add(rsReservations.getInt("id_room"));
            }


            for (Integer reservationId : reservationList) {
                roomList.remove(reservationId);
            }


            if (roomList.size() > 0)
                availableRoomNumber = roomList.get(0);


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return availableRoomNumber;
    }
}
