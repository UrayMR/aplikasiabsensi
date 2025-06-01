package model;

import config.conn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class User {
    private int id;
    private String name;
    private String email;
    private String role;

    public User(int id, String name, String email, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public static boolean emailExists(String email) {
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

    // Getter
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getRole() { return role; }
}
