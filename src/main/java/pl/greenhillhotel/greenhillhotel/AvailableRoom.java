package pl.greenhillhotel.greenhillhotel;

public class AvailableRoom extends SearchBean {

    private final int id_room;

    public AvailableRoom(String accommodation, String checkout, int people, boolean balcony, int id_room) {
        super(accommodation, checkout, people, balcony);
        this.id_room = id_room;
    }

    public int getId_room() {
        return id_room;
    }
}
