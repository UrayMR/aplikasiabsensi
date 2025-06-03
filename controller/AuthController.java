package controller;

import dao.AuthDAO;
import model.User;
import model.Admin;
import java.sql.ResultSet;

public class AuthController {
    private AuthDAO authDAO;

    public AuthController() {
        this.authDAO = new AuthDAO();
    }

    public User login(String nim, String password) {
        try {
            ResultSet rs = authDAO.getUserByNimAndPassword(nim, password);
            if (rs != null && rs.next()) {
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
