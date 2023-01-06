package pl.greenhillhotel.greenhillhotel;

public class RegisterBean {
    private final String name;
    private final String last_name;
    private final String email;
    private final String password;

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
