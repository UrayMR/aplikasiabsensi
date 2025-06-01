package controller;

import config.conn;
import helper.PasswordHelper;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthController {
    public User login(String email, String password) {
        try {
            conn koneksi = new conn();
            Connection db = koneksi.getConnection();
            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement stmt = db.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, PasswordHelper.hashPassword(password));
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("role")
                );
            }
        } catch (Exception e) {
            System.out.println("Login Error: " + e.getMessage());
        }
        return null;
    }

    public boolean emailExists(String email) {
        try {
            conn koneksi = new conn();
            Connection db = koneksi.getConnection();
            String sql = "SELECT id FROM users WHERE email = ?";
            PreparedStatement stmt = db.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.out.println("Error emailExists: " + e.getMessage());
        }
        return false;
    }

    public boolean register(String name, String email, String password, String role) {
        if (User.emailExists(email)) return false;
        try {
            conn koneksi = new conn();
            Connection db = koneksi.getConnection();
            String sql = "INSERT INTO users (name, email, password, role) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = db.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, PasswordHelper.hashPassword(password));
            stmt.setString(4, role);
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            System.out.println("Error register: " + e.getMessage());
        }
        return false;
    }

    public void logout() {
        // Implementasi logout sederhana: tidak ada session, hanya placeholder
        System.out.println("Logout berhasil.");
    }
}
