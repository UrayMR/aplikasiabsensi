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

    public List<Absensi> getAllAbsensi() {
        List<Absensi> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM absensi ORDER BY tanggal DESC, id DESC LIMIT 50";
            PreparedStatement stmt = this.db.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Absensi a = new Absensi(
                    rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getDate("tanggal"),
                    rs.getString("status")
                );
                list.add(a);
            }
        } catch (Exception e) {
            System.out.println("Gagal mengambil data absensi: " + e.getMessage());
        }
        return list;
    }

    public List<Absensi> getLastAbsensiLog() {
        List<Absensi> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM absensi ORDER BY tanggal DESC, id DESC LIMIT 10";
            PreparedStatement stmt = this.db.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Absensi a = new Absensi(
                    rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getDate("tanggal"),
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
        try {
            String sql = "SELECT * FROM absensi WHERE status LIKE ? OR user_id IN (SELECT id FROM users WHERE name LIKE ?) ORDER BY tanggal DESC, id DESC LIMIT 50";
            PreparedStatement stmt = this.db.prepareStatement(sql);
            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Absensi a = new Absensi(
                    rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getDate("tanggal"),
                    rs.getString("status")
                );
                list.add(a);
            }
        } catch (Exception e) {
            System.out.println("Gagal mencari data absensi: " + e.getMessage());
        }
        return list;
    }
}
