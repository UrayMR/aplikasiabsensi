package dao;

import config.conn;
import helper.PasswordHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthDAO {
    private conn conn;

    public AuthDAO() {
        this.conn = new conn();
    }

    public ResultSet getUserByNimAndPassword(String nim, String password) {
        try {
            Connection db = conn.getConnection();
            String sql = "SELECT * FROM users WHERE nim = ? AND password = ?";
            PreparedStatement stmt = db.prepareStatement(sql);
            stmt.setString(1, nim);
            stmt.setString(2, PasswordHelper.hashPassword(password));
            return stmt.executeQuery();
        } catch (Exception e) {
            System.out.println("AuthDAO Error: " + e.getMessage());
        }
        return null;
    }
}
