package pl.greenhillhotel.greenhillhotel;

import java.sql.*;

public class RegisterDao {

    public String insert(RegisterBean member) {
        Connection connection = new Connector().getConnection();
        String sqlQuery = "select email from user where email= ? ";
        String result = "SUCCESS";
        try {
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            ps.setString(1, member.getEmail());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = "Account with such email already exists.";
            }
            else {
                sqlQuery = "insert into user (name, surname, email, password) values (?, ?, ?, ?)";
                ps = connection.prepareStatement(sqlQuery);
                ps.setString(1, member.getName());
                ps.setString(2, member.getLast_name());
                ps.setString(3, member.getEmail());
                ps.setString(4, member.getPassword());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            result = "Data not passed";
        }
        return result;
    }
}
