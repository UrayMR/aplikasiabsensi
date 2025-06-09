package model;

import java.sql.Timestamp;

public class Absensi {
    private int id;
    private int userId;
    private Timestamp timestamp;
    private String status;

    public Absensi(int id, int userId, Timestamp timestamp, String status) {
        this.id = id;
        this.userId = userId;
        this.timestamp = timestamp;
        this.status = status;
    }

    // Getter dan Setter untuk id, userId, timestamp, status
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public Timestamp getTimestamp() { return timestamp; }
    public void setTimestamp(Timestamp timestamp) { this.timestamp = timestamp; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}