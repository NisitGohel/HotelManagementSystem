package dao;

import db.DBConnection;
import java.sql.*;
import java.util.*;
import java.sql.Date;
import model.Reservation;

public class ReservationDAO {

    /**
     *
     * @param name
     * @param type
     * @param checkIn
     * @param checkOut
     */
    public static void addReservation(String name, String type, Date checkIn, Date checkOut) {
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement(
                "INSERT INTO reservation (customer_name, room_type, check_in, check_out) VALUES (?, ?, ?, ?)"
            );

            pst.setString(1, name);
            pst.setString(2, type);
            pst.setDate(3, checkIn);
            pst.setDate(4, checkOut);

            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Reservation> getAllReservations() {
        List<Reservation> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM reservation");

            while (rs.next()) {
                list.add(new Reservation(
                        rs.getInt("reservation_id"),
                        rs.getString("customer_name"),
                        rs.getString("room_type"),
                        rs.getDate("check_in"),
                        rs.getDate("check_out"),
                        rs.getString("status")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // 🔥 AUTO ASSIGN ROOM + APPROVE
    public static void approveReservation(int id) {
        try {
            Connection con = DBConnection.getConnection();

            // Get reservation data
            PreparedStatement pst1 = con.prepareStatement(
                "SELECT * FROM reservation WHERE reservation_id=?"
            );
            pst1.setInt(1, id);
            ResultSet rs = pst1.executeQuery();

            if (rs.next()) {

                String type = rs.getString("room_type");
                String name = rs.getString("customer_name");

                // Find available room of that type
                PreparedStatement pst2 = con.prepareStatement(
                    "SELECT room_id FROM room WHERE type=? AND status='Available' LIMIT 1"
                );
                pst2.setString(1, type);

                ResultSet roomRs = pst2.executeQuery();

                if (roomRs.next()) {
                    int roomId = roomRs.getInt("room_id");

                    // Insert into booking
                    PreparedStatement pst3 = con.prepareStatement(
                        "INSERT INTO booking (room_id, customer_name, status) VALUES (?, ?, 'Checked-In')"
                    );
                    pst3.setInt(1, roomId);
                    pst3.setString(2, name);
                    pst3.executeUpdate();

                    // Update room
                    PreparedStatement pst4 = con.prepareStatement(
                        "UPDATE room SET status='Booked' WHERE room_id=?"
                    );
                    pst4.setInt(1, roomId);
                    pst4.executeUpdate();
                }

                // Update reservation status
                PreparedStatement pst5 = con.prepareStatement(
                    "UPDATE reservation SET status='Approved' WHERE reservation_id=?"
                );
                pst5.setInt(1, id);
                pst5.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}