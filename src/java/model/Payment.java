package model;

public class Payment {
    private int roomId;
    private double amount;
    private String method;
    private String status;

    public Payment(int roomId, double amount, String method, String status) {
        this.roomId = roomId;
        this.amount = amount;
        this.method = method;
        this.status = status;
    }

    public int getRoomId() { return roomId; }
    public double getAmount() { return amount; }
    public String getMethod() { return method; }
    public String getStatus() { return status; }
}