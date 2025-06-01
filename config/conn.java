package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class conn {
    private String url;
    private String user;
    private String password;

    public conn() {
        this.url = EnvLoader.get("DB_URL");
        this.user = EnvLoader.get("DB_USER");
        this.password = EnvLoader.get("DB_PASSWORD");
    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("Koneksi Gagal: " + e.getMessage());
            return null;
        }
    }
}
