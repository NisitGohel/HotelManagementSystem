package model;

public class Booking {
    private int roomId;
    private String customerName;
    private String status;
    private int days;
    private double totalAmount;

    public Booking(int roomId, String customerName, String status, int days, double totalAmount) {
        this.roomId = roomId;
        this.customerName = customerName;
        this.status = status;
        this.days = days;
        this.totalAmount = totalAmount;
    }

    public int getRoomId() { return roomId; }
    public String getCustomerName() { return customerName; }
    public String getStatus() { return status; }
    public int getDays() { return days; }
    public double getTotalAmount() { return totalAmount; }
}