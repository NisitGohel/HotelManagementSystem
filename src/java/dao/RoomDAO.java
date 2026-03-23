package dao;

import db.DBConnection;
import java.sql.*;
import java.util.*;
import model.Room;

public class RoomDAO {

    public static void addRoom(Room room) {
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement(
                "INSERT INTO room VALUES (?, ?, ?, ?)"
            );

            pst.setInt(1, room.getId());
            pst.setString(2, room.getType());
            pst.setDouble(3, room.getPrice());
            pst.setString(4, "Available");

            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Room> getAllRooms() {
        List<Room> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM room");

            while (rs.next()) {
                list.add(new Room(
                    rs.getInt("room_id"),
                    rs.getString("type"),
                    rs.getDouble("price"),
                    rs.getString("status")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}