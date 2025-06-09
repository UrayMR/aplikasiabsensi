package com.example.aplikasiabsensi.controller;

import com.example.aplikasiabsensi.model.Absen;
import com.example.aplikasiabsensi.dao.AbsenDAO;  // Pastikan DAO ini sesuai dengan struktur Anda
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/absen")
public class AbsenController {

    // POST request untuk menangani absensi
    @PostMapping("/input")
    public String inputAbsen(@RequestParam("nim") String nim, @RequestParam("jenis_absen") String jenisAbsen) {
        // Buat objek absen dan simpan ke database
        Absen absen = new Absen(nim, jenisAbsen);
        
        // Gunakan DAO untuk menyimpan data ke database
        AbsenDAO absenDAO = new AbsenDAO();
        try {
            absenDAO.simpanAbsen(absen);
            return "Absensi berhasil!";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Terjadi kesalahan saat mencatat absensi.";
        }
    }
}
