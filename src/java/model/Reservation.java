package model;

import java.sql.Date;

public class Reservation {
    private int id;
    private String name;
    private String roomType;
    private Date checkIn;
    private Date checkOut;
    private String status;

    public Reservation(int id, String name, String roomType, Date checkIn, Date checkOut, String status) {
        this.id = id;
        this.name = name;
        this.roomType = roomType;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.status = status;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getRoomType() { return roomType; }
    public Date getCheckIn() { return checkIn; }
    public Date getCheckOut() { return checkOut; }
    public String getStatus() { return status; }
}