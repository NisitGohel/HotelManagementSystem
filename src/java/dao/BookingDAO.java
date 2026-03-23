package dao;

import db.DBConnection;
import java.sql.*;

public class BookingDAO {

    public static void bookRoom(int roomId, String name, int days) {
        try {
            Connection con = DBConnection.getConnection();

            // Get room price
            PreparedStatement pst1 = con.prepareStatement(
                "SELECT price FROM room WHERE room_id=?"
            );
            pst1.setInt(1, roomId);
            ResultSet rs = pst1.executeQuery();

            double price = 0;
            if (rs.next()) {
                price = rs.getDouble("price");
            }

            double total = price * days;

            // Insert booking
            PreparedStatement pst = con.prepareStatement(
                "INSERT INTO booking (room_id, customer_name, status, days, total_amount) VALUES (?, ?, 'Checked-In', ?, ?)"
            );
            pst.setInt(1, roomId);
            pst.setString(2, name);
            pst.setInt(3, days);
            pst.setDouble(4, total);
            pst.executeUpdate();

            // Update room
            PreparedStatement pst2 = con.prepareStatement(
                "UPDATE room SET status='Booked' WHERE room_id=?"
            );
            pst2.setInt(1, roomId);
            pst2.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getBill(int roomId) {
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement(
                "SELECT * FROM booking WHERE room_id=? ORDER BY booking_id DESC LIMIT 1"
            );
            pst.setInt(1, roomId);

            return pst.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}