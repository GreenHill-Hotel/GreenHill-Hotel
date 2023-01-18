package pl.greenhillhotel.greenhillhotel;

/**
 * Email and password data which is later passed to the proper Dao to create a session and login the user.
 */
public class LoginBean {
    private final String email;
    private final String password;

    public LoginBean(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
