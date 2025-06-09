package dao;

import config.conn;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private conn conn;
    private Connection db;

    public UserDAO() {
        this.conn = new conn();
        try {
            this.db = conn.getConnection();
        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
            this.db = null;
        }
    }

    public List<User> getAllKaryawan(int page, int pageSize) {
        List<User> list = new ArrayList<>();
        try {
            int offset = (page - 1) * pageSize;
            String sql = "SELECT * FROM users WHERE role = 'karyawan' ORDER BY id ASC LIMIT ? OFFSET ?";
            PreparedStatement stmt = this.db.prepareStatement(sql);
            stmt.setInt(1, pageSize);
            stmt.setInt(2, offset);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                User u = new User(
                    rs.getInt("id"),
                    rs.getString("nim"),
                    rs.getString("name"),
                    rs.getString("password"),
                    rs.getString("role")
                );
                list.add(u);
            }
        } catch (Exception e) {
            System.out.println("Gagal mengambil data karyawan: " + e.getMessage());
        }
        return list;
    }

    public boolean insert(String name, String nim, String password, String role) {
        try {
            String sql = "INSERT INTO users (name, nim, password, role) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = this.db.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, nim);
            stmt.setString(3, password);
            stmt.setString(4, role);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Gagal menambahkan user: " + e.getMessage());
            return false;
        }
    }

    public User getByNim(String nim) {
        try {
            String sql = "SELECT * FROM users WHERE nim = ?";
            PreparedStatement stmt = this.db.prepareStatement(sql);
            stmt.setString(1, nim);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                    rs.getInt("id"),
                    rs.getString("nim"),
                    rs.getString("name"),
                    rs.getString("password"),
                    rs.getString("role")
                );
            }
        } catch (Exception e) {
            System.out.println("Gagal mengambil user berdasarkan NIM: " + e.getMessage());
        }
        return null;
    }

    public User getById(int id) {
        try {
            String sql = "SELECT * FROM users WHERE id = ?";
            PreparedStatement stmt = this.db.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                    rs.getInt("id"),
                    rs.getString("nim"),
                    rs.getString("name"),
                    rs.getString("password"),
                    rs.getString("role")
                );
            }
        } catch (Exception e) {
            System.out.println("Gagal mengambil user berdasarkan ID: " + e.getMessage());
        }
        return null;
    }

    public boolean update(int id, String name, String password) {
        try {
            String sql;
            PreparedStatement stmt;
            if (password == null || password.isEmpty()) {
                sql = "UPDATE users SET name = ? WHERE id = ?";
                stmt = this.db.prepareStatement(sql);
                stmt.setString(1, name);
                stmt.setInt(2, id);
            } else {
                sql = "UPDATE users SET name = ?, password = ? WHERE id = ?";
                stmt = this.db.prepareStatement(sql);
                stmt.setString(1, name);
                stmt.setString(2, password);
                stmt.setInt(3, id);
            }
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Gagal mengupdate user: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteByNim(String nim) {
        try {
            String sql = "DELETE FROM users WHERE nim = ?";
            PreparedStatement stmt = this.db.prepareStatement(sql);
            stmt.setString(1, nim);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Gagal menghapus user: " + e.getMessage());
            return false;
        }
    }

    public List<User> search(String keyword) {
        List<User> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM users WHERE (name LIKE ? OR nim LIKE ?) AND role = 'karyawan' ORDER BY id ASC";
            PreparedStatement stmt = this.db.prepareStatement(sql);
            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                User u = new User(
                    rs.getInt("id"),
                    rs.getString("nim"),
                    rs.getString("name"),
                    rs.getString("password"),
                    rs.getString("role")
                );
                list.add(u);
            }
        } catch (Exception e) {
            System.out.println("Gagal mencari user: " + e.getMessage());
        }
        return list;
    }
}
