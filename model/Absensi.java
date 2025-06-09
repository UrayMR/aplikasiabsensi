package model;

import java.sql.Date;

public class Absensi {
    // Untuk controller AbsensiController
    private String nim;
    private String jenisAbsen;

    // Untuk AdminDAO
    private int id;
    private int userId;
    private Date tanggal;
    private String status;

    // Constructor untuk AbsensiController
    public Absensi(String nim, String jenisAbsen) {
        this.nim = nim;
        this.jenisAbsen = jenisAbsen;
    }

    // Constructor untuk AdminDAO
    public Absensi(int id, int userId, Date tanggal, String status) {
        this.id = id;
        this.userId = userId;
        this.tanggal = tanggal;
        this.status = status;
    }

    // Getter dan Setter untuk nim dan jenisAbsen
    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }

    public String getJenisAbsen() { return jenisAbsen; }
    public void setJenisAbsen(String jenisAbsen) { this.jenisAbsen = jenisAbsen; }

    // Getter dan Setter untuk id, userId, tanggal, status
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public Date getTanggal() { return tanggal; }
    public void setTanggal(Date tanggal) { this.tanggal = tanggal; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}