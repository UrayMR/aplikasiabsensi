package com.example.aplikasiabsensi.dao;

import com.example.aplikasiabsensi.model.Absensi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AbsensiDAO {

    public void simpanAbsensi(Absensi absensi) throws Exception {
        // Koneksi ke database
        String url = "jdbc:mysql://localhost:3306/aplikasiabsensi";
        String username = "root";  
        String password = "";  

        // Query untuk menyimpan absensi
        String query = "INSERT INTO absensi (nim, jenis_absen) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, absensi.getNim());
            stmt.setString(2, absensi.getJenisAbsen());

            // Menjalankan query untuk menyimpan data
            stmt.executeUpdate();
        }
    }
}
