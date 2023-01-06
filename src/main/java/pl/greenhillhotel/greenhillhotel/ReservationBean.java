package pl.greenhillhotel.greenhillhotel;

public class ReservationBean {
    private final int id_room;
    private final int id_user;
    private final String bed_config;
    private final boolean tv;
    private final String accommodation;
    private final String checkout;

    public ReservationBean(int id_room, int id_user, String bed_config, boolean tv, String accommodation, String checkout) {
        this.id_room = id_room;
        this.id_user = id_user;
        this.bed_config = bed_config;
        this.tv = tv;
        this.accommodation = accommodation;
        this.checkout = checkout;
    }

    public int getId_room() {
        return id_room;
    }

    public int getId_user() {
        return id_user;
    }

    public String getBed_config() {
        return bed_config;
    }

    public boolean isTv() {
        return tv;
    }

    public String getAccommodation() {
        return accommodation;
    }

    public String getCheckout() {
        return checkout;
    }
}
