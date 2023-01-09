package pl.greenhillhotel.greenhillhotel;

import java.math.BigInteger;
import java.security.MessageDigest;

public class PasswordEncryptor {
    public String encrypt(String password) throws Exception {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(password.getBytes(), 0, password.length());
        return new BigInteger(1, m.digest()).toString(16);
    }
}
