package model;

public class Room {
    private int id;
    private String type;
    private double price;
    private String status;

    public Room(int id, String type, double price, String status) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.status = status;
    }

    public int getId() { return id; }
    public String getType() { return type; }
    public double getPrice() { return price; }
    public String getStatus() { return status; }
}