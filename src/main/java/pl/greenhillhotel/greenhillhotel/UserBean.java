package pl.greenhillhotel.greenhillhotel;

/**
 * Object of the user.
 * It contains all the essential data which is passed between servlets when logged in.
 *
 * @see CancelReservationServlet
 * @see ReservationServlet
 * @see MyReservationsServlet
 * @see LoginDao
 * @see LoginServlet
 */
public class UserBean {
    private int id;
    private String name;
    private String surname;
    private String email;
    private boolean admin;
    private boolean valid;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAdmin() {
        return admin;
    }

    public boolean isValid() {
        return valid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
