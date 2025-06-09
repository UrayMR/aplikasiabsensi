package com.example.aplikasiabsensi.controller;

import com.example.aplikasiabsensi.model.Absen;
import com.example.aplikasiabsensi.dao.AbsenDAO;  
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/absen")
public class AbsenController {

    // POST request untuk menangani absensi
    @PostMapping("/input")
    public String inputAbsen(@RequestParam("nim") String nim, @RequestParam("jenisAbsen") String jenisAbsen) {
        if (nim == null || nim.isEmpty() || !nim.matches("\\d{8}")) {
            return "NIM tidak valid!";
        }
        if (!jenisAbsen.equals("masuk") && !jenisAbsen.equals("keluar") && !jenisAbsen.equals("izin")) {
            return "Jenis absen tidak valid!";
        }

        Absensi absen = new Absensi(nim, jenisAbsen);
        try {
            absensiDAO.simpanAbsensi(absen);
            return "Absensi berhasil!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Terjadi kesalahan saat mencatat absensi.";
        }
    }
}
