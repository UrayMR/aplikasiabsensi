package controller;

import config.conn;
import helper.PasswordHelper;
import model.User;
import model.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthController {
    public User login(String nim, String password) {
        try {
            conn koneksi = new conn();
            Connection db = koneksi.getConnection();

            String sql = "SELECT * FROM users WHERE nim = ? AND password = ?";
            PreparedStatement stmt = db.prepareStatement(sql);
            stmt.setString(1, nim);
            stmt.setString(2, PasswordHelper.hashPassword(password));
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String nimAuth = rs.getString("nim");
                String role = rs.getString("role");
                switch (role) {
                    case "admin":
                        return new Admin(id, name, nimAuth);
                    default:
                        return null;
                }
            }
        } catch (Exception e) {
            System.out.println("Login Error: " + e.getMessage());
        }
        return null;
    }

    public void logout() {
        System.out.println("Logout berhasil.");
    }
}
