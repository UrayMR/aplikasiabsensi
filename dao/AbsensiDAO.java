package dao;

import config.conn;
import java.sql.Connection;

public class AbsensiDAO {
    private conn conn;
    private Connection db;

    public AbsensiDAO() {
        this.conn = new conn();
        try {
            this.db = conn.getConnection();
        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
            this.db = null;
        }
    }

    // Fungsi insertAbsensi (boolean)

    // Fungsi getUserIdByNim (int)
}
