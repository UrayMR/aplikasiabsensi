package controller;

import model.Absensi;
import dao.AbsensiDAO;  
import annotation.*;

@RestController
@RequestMapping("/absen")
public class AbsensiController {

    // Inisialisasi AbsensiDAO
    private final AbsensiDAO absensiDAO;

    // Constructor 
    public AbsensiController() {
        this.absensiDAO = new AbsensiDAO();
    }

    // POST request untuk menangani absensi
    @PostMapping("/input")
    public String inputAbsen(@RequestParam("nim") String nim, @RequestParam("jenisAbsen") String jenisAbsen) {
        if (nim == null || nim.isEmpty() || !nim.matches("\\d{9}")) {
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
