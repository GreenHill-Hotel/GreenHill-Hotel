package pl.greenhillhotel.greenhillhotel;

public class SearchBean {
    private final String accommodation;
    private final String checkout;
    private final int people;
    private final boolean balcony;

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
