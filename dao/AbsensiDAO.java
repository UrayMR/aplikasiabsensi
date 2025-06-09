package dao;

import config.conn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AbsensiDAO {
    private conn conn;
    private Connection db;

    public AbsensiDAO() {
        this.conn = new conn();
        try {
            this.db = conn.getConnection();
        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
            this.db = null;
        }
    }

    // Fungsi simpanAbsensi (boolean)
    public boolean simpanAbsensi(int userId, String status) {
        if (this.db == null) return false;
        try {
            String sql = "INSERT INTO absensi (user_id, timestamp, status) VALUES (?, CURRENT_TIMESTAMP, ?)";
            PreparedStatement stmt = db.prepareStatement(sql);
            stmt.setInt(1, userId);
            stmt.setString(2, status);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Gagal insert absensi: " + e.getMessage());
            return false;
        }
    }

    // Fungsi getUserIdByNim (int)
    public int getUserIdByNim(String nim) {
        if (this.db == null) return -1;
        try {
            String sql = "SELECT id FROM users WHERE nim = ?";
            PreparedStatement stmt = db.prepareStatement(sql);
            stmt.setString(1, nim);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (Exception e) {
            System.out.println("Gagal get user id by nim: " + e.getMessage());
        }
        return -1;
    }

    // Fungsi getStatusAbsensiHariIni: cek status absensi user hari ini
    public String getStatusAbsensiHariIni(int userId) {
        if (this.db == null) return null;
        try {
            String sql = "SELECT status FROM absensi WHERE user_id = ? AND DATE(timestamp) = CURRENT_DATE LIMIT 1";
            PreparedStatement stmt = db.prepareStatement(sql);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("status");
            }
        } catch (Exception e) {
            System.out.println("Gagal cek status absensi hari ini: " + e.getMessage());
        }
        return null;
    }

    // Mendapatkan tanggal absensi terakhir user (format yyyy-MM-dd)
    public String getLastAbsensiDate(int userId) {
        if (this.db == null) return null;
        try {
            String sql = "SELECT DATE(timestamp) as last_date FROM absensi WHERE user_id = ? ORDER BY timestamp DESC LIMIT 1";
            PreparedStatement stmt = db.prepareStatement(sql);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("last_date");
            }
        } catch (Exception e) {
            System.out.println("Gagal get last absensi date: " + e.getMessage());
        }
        return null;
    }

    // Insert alpha untuk tanggal bolong
    public void insertAlphaForMissingDates(int userId, String lastDate, String today) {
        try {
            java.time.LocalDate last = lastDate == null ? null : java.time.LocalDate.parse(lastDate);
            java.time.LocalDate now = java.time.LocalDate.parse(today);
            if (last == null) return; // Jika belum pernah absen, tidak perlu alpha
            java.time.LocalDate next = last.plusDays(1);
            while (next.isBefore(now)) {
                String sql = "INSERT INTO absensi (user_id, timestamp, status) VALUES (?, ?, 'alpha')";
                PreparedStatement stmt = db.prepareStatement(sql);
                stmt.setInt(1, userId);
                stmt.setString(2, next.toString() + " 08:00:00"); // jam default
                stmt.executeUpdate();
                next = next.plusDays(1);
            }
        } catch (Exception e) {
            System.out.println("Gagal insert alpha: " + e.getMessage());
        }
    }
}
