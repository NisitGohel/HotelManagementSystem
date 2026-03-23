package dao;

import db.DBConnection;
import java.sql.*;

public class UserDAO {

    public static String validate(String username, String password) {
        String role = null;

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement(
                "SELECT role FROM users WHERE username=? AND password=?"
            );

            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                role = rs.getString("role");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return role;
    }
}