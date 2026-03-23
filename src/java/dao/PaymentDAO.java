package dao;

import db.DBConnection;
import java.sql.*;

public class PaymentDAO {

    public static double getAmount(int roomId) {
        double amount = 0;

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement(
                "SELECT total_amount FROM booking WHERE room_id=? ORDER BY booking_id DESC LIMIT 1"
            );

            pst.setInt(1, roomId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                amount = rs.getDouble("total_amount");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return amount;
    }

    public static void makePayment(int roomId, String method) {
        try {
            Connection con = DBConnection.getConnection();

            double amount = getAmount(roomId);

            PreparedStatement pst = con.prepareStatement(
                "INSERT INTO payment (room_id, amount, method, status) VALUES (?, ?, ?, 'Paid')"
            );

            pst.setInt(1, roomId);
            pst.setDouble(2, amount);
            pst.setString(3, method);

            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}