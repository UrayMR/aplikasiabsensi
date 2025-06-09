package controller;

import dao.AbsensiDAO;

public class AbsensiController {

    // Inisialisasi AbsensiDAO
    private final AbsensiDAO absensiDAO;

    // Constructor 
    public AbsensiController() {
        this.absensiDAO = new AbsensiDAO();
    }

    // Method untuk menangani input absensi
    public String inputAbsen(String nim, String status) {
        if (nim == null || nim.isEmpty() || !nim.matches("\\d{9,}")) {
            return "NIM tidak valid!";
        }

        if (!status.equals("hadir") && !status.equals("sakit") && !status.equals("izin")) {
            return "Jenis absen tidak valid!";
        }

        int userId = absensiDAO.getUserIdByNim(nim);
        if (userId == -1) {
            return "NIM tidak ditemukan!";
       }

        // Cek dan isi alpha jika ada hari bolong
        String today = java.time.LocalDate.now().toString();
        String lastDate = absensiDAO.getLastAbsensiDate(userId);
        absensiDAO.insertAlphaForMissingDates(userId, lastDate, today);

        // Cek apakah sudah absen hari ini
        String statusSebelumnya = absensiDAO.getStatusAbsensiHariIni(userId);
        if (statusSebelumnya != null) {
            return "Anda sudah absen hari ini dengan status: " + statusSebelumnya + ".";
        }

        boolean success = absensiDAO.simpanAbsensi(userId, status);
        
        if (success) {
            String waktu = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return nim + " telah berhasil absensi pada " + waktu + " dengan status " + status + ".";
        } else {
            return "Gagal mencatat absensi!";
        }
    }
}