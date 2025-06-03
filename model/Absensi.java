package model;

import java.sql.Date;

public class Absensi {
    private int id;
    private int userId;
    private Date tanggal;
    private String status; // hadir, izin, sakit, dll

    public Absensi() {}

    public Absensi(int id, int userId, Date tanggal, String status) {
        this.id = id;
        this.userId = userId;
        this.tanggal = tanggal;
        this.status = status;
    }

    public int getId() { return id; }
    public int getUserId() { return userId; }
    public Date getTanggal() { return tanggal; }
    public String getStatus() { return status; }

    public void setId(int id) { this.id = id; }
    public void setUserId(int userId) { this.userId = userId; }
    public void setTanggal(Date tanggal) { this.tanggal = tanggal; }
    public void setStatus(String status) { this.status = status; }
}
