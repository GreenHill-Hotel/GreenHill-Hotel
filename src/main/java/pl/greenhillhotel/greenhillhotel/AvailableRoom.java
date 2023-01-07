package pl.greenhillhotel.greenhillhotel;

import java.util.HashMap;
import java.util.Map;

public class AvailableRoom extends SearchBean {

    private final int id_room;
    private final String balconyText;

    public AvailableRoom(String accommodation, String checkout, int people, boolean balcony, int id_room) {
        super(accommodation, checkout, people, balcony);
        this.id_room = id_room;
        balconyText = convertBooleanToText(balcony);
    }

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
