package pl.greenhillhotel.greenhillhotel;

import java.util.HashMap;
import java.util.Map;

/**
 * Representation of the first available room.
 */
public class AvailableRoom extends SearchBean {

    private final int id_room;
    private final String balconyText;

    /**
     * Class constructor.
     *
     * @param accommodation start date of the reservation
     * @param checkout end date of the reservation
     * @param people capacity of the room
     * @param balcony whether room should have a balcony
     * @param id_room number of the room
     */
    public AvailableRoom(String accommodation, String checkout, int people, boolean balcony, int id_room) {
        super(accommodation, checkout, people, balcony);
        this.id_room = id_room;
        balconyText = convertBooleanToText(balcony);
    }

    /**
     * Returns a text representations of given boolean value.
     * This method is used to display a boolean value in more user-friendly style.
     *
     * @param state a boolean value
     * @return text representation of boolean in Polish language
     */
    private String convertBooleanToText(boolean state) {
        Map<Boolean, String> map = new HashMap<>();
        map.put(true, "Tak");
        map.put(false, "Nie");
        return map.get(state);
    }

    public int getId_room() {
        return id_room;
    }

    public String getBalconyText() {return balconyText;}
}
