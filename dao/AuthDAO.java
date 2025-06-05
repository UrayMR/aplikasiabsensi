package dao;

import config.conn;
import helper.PasswordHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthDAO {
    private conn conn;
    private Connection db;

    public AuthDAO() {
        this.conn = new conn();
        
        try {
            this.db = conn.getConnection();
        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
            this.db = null; // Ensure db is null if connection fails
        }
    }

    public ResultSet getUserByNimAndPassword(String nim, String password) {
        try {
            String sql = "SELECT * FROM users WHERE nim = ? AND password = ?";
            PreparedStatement stmt = this.db.prepareStatement(sql);
            stmt.setString(1, nim);
            stmt.setString(2, PasswordHelper.hashPassword(password));
            return stmt.executeQuery();
        } catch (Exception e) {
            System.out.println("AuthDAO Error: " + e.getMessage());
        }
        return null;
    }
}
