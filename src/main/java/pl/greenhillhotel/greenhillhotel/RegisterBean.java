package pl.greenhillhotel.greenhillhotel;

/**
 * User data which is later passed to the Dao to register new user.
 *
 * @see RegisterDao
 */
public class RegisterBean {
    private final String name;
    private final String last_name;
    private final String email;
    private final String password;

    /**
     * Class constructor.
     *
     * @param name users' first name.
     * @param last_name users' last name.
     * @param email users' email address.
     * @param password users' password.
     */
    public RegisterBean(String name, String last_name, String email, String password) {
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
