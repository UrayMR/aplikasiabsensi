package dao;

import model.Absensi;
import config.conn;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {
    private conn conn;
    private Connection db;

    public AdminDAO() {
        this.conn = new conn();
        try {
            this.db = conn.getConnection();
        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
            this.db = null;
        }
    }

    public List<Absensi> getLastAbsensiLog() {
        List<Absensi> list = new ArrayList<>();
        if (this.db == null) {
            System.out.println("Koneksi database gagal.");
            return list;
        }
        try {
            String sql = "SELECT * FROM absensi ORDER BY timestamp DESC, id DESC LIMIT 10";
            PreparedStatement stmt = this.db.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Absensi a = new Absensi(
                    rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getTimestamp("timestamp"),
                    rs.getString("status")
                );
                list.add(a);
            }
        } catch (Exception e) {
            System.out.println("Gagal mengambil log absensi: " + e.getMessage());
        }
        return list;
    }

    public List<Absensi> searchAbsensi(String keyword) {
        List<Absensi> list = new ArrayList<>();
        // Cek jika koneksi db null
        if (this.db == null) {
            System.out.println("Koneksi database gagal.");
            return list; // Jika koneksi gagal, kembalikan list kosong
        }

        try {
            String sql = "SELECT * FROM absensi WHERE status LIKE ? OR user_id IN (SELECT id FROM users WHERE name LIKE ? OR nim LIKE ?) ORDER BY timestamp DESC, id DESC LIMIT 50";
            PreparedStatement stmt = this.db.prepareStatement(sql);
            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");
            stmt.setString(3, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Absensi a = new Absensi(
                    rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getTimestamp("timestamp"),
                    rs.getString("status")
                );
                list.add(a);
            }
        } catch (Exception e) {
            System.out.println("Gagal mencari data absensi: " + e.getMessage());
        }
        return list;
    }

    public List<Absensi> getAllAbsensi(int page, int pageSize) {
        List<Absensi> list = new ArrayList<>();
        if (this.db == null) {
            System.out.println("Koneksi database gagal.");
            return list;
        }
        try {
            int offset = (page - 1) * pageSize;
            String sql = "SELECT * FROM absensi ORDER BY timestamp DESC, id DESC LIMIT ? OFFSET ?";
            PreparedStatement stmt = this.db.prepareStatement(sql);
            stmt.setInt(1, pageSize);
            stmt.setInt(2, offset);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Absensi a = new Absensi(
                    rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getTimestamp("timestamp"),
                    rs.getString("status")
                );
                list.add(a);
            }
        } catch (Exception e) {
            System.out.println("Gagal mengambil data absensi: " + e.getMessage());
        }
        return list;
    }
}
