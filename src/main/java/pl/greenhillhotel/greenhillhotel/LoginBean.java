package pl.greenhillhotel.greenhillhotel;

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
