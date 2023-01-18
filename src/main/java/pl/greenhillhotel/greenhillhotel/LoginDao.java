package pl.greenhillhotel.greenhillhotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Handling sql queries related to logging in the user.
 *
 * @see LoginBean
 * @see UserBean
 */
public class LoginDao {
    /**
     * Method used to log in the user.
     *
     * @param data object containing email and password of the user.
     * @return user object containing all the important information about it.
     *
     * @see LoginBean
     * @see UserBean
     */
    public UserBean login(LoginBean data) {
        UserBean user = new UserBean();
        Connection connection = new Connector().getConnection();
        String sqlQuery = "SELECT * FROM user WHERE email= ? AND password = ? ";
        try {
            String encryptedPassword = new PasswordEncryptor().encrypt(data.getPassword());
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            ps.setString(1, data.getEmail());
            ps.setString(2, encryptedPassword);
            ResultSet rs = ps.executeQuery();

            if (!rs.next())
                user.setValid(false);

            else {
                user.setId(rs.getInt("id_registration"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setEmail(rs.getString("email"));
                user.setAdmin(rs.getBoolean("admin"));
                user.setValid(true);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
