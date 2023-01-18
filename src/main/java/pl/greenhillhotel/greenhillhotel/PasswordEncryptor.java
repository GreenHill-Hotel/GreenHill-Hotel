package pl.greenhillhotel.greenhillhotel;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Encryptor used to prepare the password to be put into database.
 */
public class PasswordEncryptor {
    /**
     * Method to encrypt given password.
     *
     * @param password password that will be encrypted
     * @return encrypted password
     *
     * @see RegisterDao
     */
    public String encrypt(String password) throws Exception {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(password.getBytes(), 0, password.length());
        return new BigInteger(1, m.digest()).toString(16);
    }
}
