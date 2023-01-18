package pl.greenhillhotel.greenhillhotel;

/**
 * Data essential to properly choose the available room to reserve.
 *
 * @see SearchDao
 */
public class SearchBean {
    private final String accommodation;
    private final String checkout;
    private final int people;
    private final boolean balcony;

    /**
     * Class constructor.
     *
     * @param accommodation start date of the reservation.
     * @param checkout end date of the reservation.
     * @param people number of people to filter the capacity of desired room.
     * @param balcony whether room should have the balcony.
     */
    public SearchBean(String accommodation, String checkout, int people, boolean balcony) {
        this.accommodation = accommodation;
        this.checkout = checkout;
        this.people = people;
        this.balcony = balcony;
    }

    public String getAccommodation() {
        return accommodation;
    }

    public String getCheckout() {
        return checkout;
    }

    public int getPeople() {
        return people;
    }

    public boolean isBalcony() {
        return balcony;
    }
}
