package pl.greenhillhotel.greenhillhotel;

/**
 * Data essential to properly register new reservation in the database.
 *
 * @see ReservationDao
 */
public class ReservationBean {
    private int id_reservation;
    private String name;
    private String surname;
    private boolean cancelable;
    private final int id_room;
    private final int id_user;
    private final String bed_config;
    private final boolean tv;
    private final String tvText;
    private final String accommodation;
    private final String checkout;

    /**
     * Class constructor.
     *
     * @param id_room id of the selected room.
     * @param id_user id of the user.
     * @param bed_config bed configuration picked by the user.
     * @param tv whether the reserved room has tv.
     * @param accommodation start date of the reservation.
     * @param checkout end date of the reservation.
     */
    public ReservationBean(int id_room, int id_user, String bed_config, boolean tv, String accommodation, String checkout) {
        this.id_room = id_room;
        this.id_user = id_user;
        this.bed_config = bed_config;
        this.tv = tv;
        if (tv)
            this.tvText = "Tak";
        else
            this.tvText = "Nie";
        this.accommodation = accommodation;
        this.checkout = checkout;
    }

    public int getId_reservation() {
        return id_reservation;
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

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getTvText() {
        return tvText;
    }

    public boolean isCancelable() {
        return cancelable;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCancelable(boolean cancelable) {
        this.cancelable = cancelable;
    }
}
