package view.admin;

import controller.AdminController;
import model.Absensi;
import java.util.List;
import java.util.Scanner;

import model.User;
import view.AdminView;
import dao.UserDAO;

public class AdminAbsensiView extends AdminView {
    private final AdminController adminController;
    private final UserDAO userDAO = new UserDAO();

    public AdminAbsensiView(User user) {
        super(user, new Scanner(System.in));
        this.adminController = new AdminController();
    }

    public void showAbsensiMenu() {
        boolean absensiMenu = true;
        while (absensiMenu) {
            System.out.println("\n=== Menu Kelola Absensi ===");
            System.out.println("1. Tampilkan Semua Absensi");
            System.out.println("2. Cari Absensi (nim/nama/status)");
            System.out.println("3. Lihat Log Absensi Terakhir");
            System.out.println("4. Kembali");
            System.out.print("Pilih menu (1/2/3/4): ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    showAllAbsensi();
                    break;
                case "2":
                    System.out.print("Masukkan kata kunci pencarian: ");
                    String keyword = scanner.nextLine();
                    searchAbsensi(keyword);
                    break;
                case "3":
                    showLogAbsensi();
                    break;
                case "4":
                    absensiMenu = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void printAbsensiList(List<Absensi> list, String header) {
        if (list == null || list.isEmpty()) {
            System.out.println("Tidak ada data absensi.");
            return;
        }
        System.out.println("\n" + header);
        for (Absensi data : list) {
            // Ambil user berdasarkan userId untuk mendapatkan NIM
            User user = userDAO.getById(data.getUserId());
            String nim = user != null ? user.getNim() : "-";
            System.out.printf("ID: %d, NIM: %s, Timestamp: %s, Status: %s\n",
                data.getId(), nim, data.getTimestamp(), data.getStatus());
        }
    }

    private void showAllAbsensi() {
        int page = 1;
        final int pageSize = 5;
        while (true) {
            List<Absensi> attendances = adminController.getAllAbsensi(page, pageSize);
            if (attendances.isEmpty()) {
                System.out.println("Tidak ada data absensi.");
                return;
            }
            printAbsensiList(attendances, "--- Semua Data Absensi (Halaman " + page + ") ---");
            System.out.print("\n[N]ext, [P]revious, [E]xit: ");
            String action = scanner.nextLine().toLowerCase();
            if (action.equals("n")) page++;
            else if (action.equals("p") && page > 1) page--;
            else break;
        }
    }

    private void showLogAbsensi() {
        List<Absensi> log = adminController.getLastAbsensiLog();
        printAbsensiList(log, "--- Log Absensi 10 Terakhir ---");
    }

    private void searchAbsensi(String keyword) {
        List<Absensi> results = adminController.searchAbsensi(keyword);
        if (results == null || results.isEmpty()) {
            System.out.println("Tidak ada hasil ditemukan.");
            return;
        }

        java.util.Map<Integer, java.util.List<Absensi>> grouped = new java.util.LinkedHashMap<>();
        for (Absensi abs : results) {
            grouped.computeIfAbsent(abs.getUserId(), k -> new java.util.ArrayList<>()).add(abs);
        }
        
        for (Integer userId : grouped.keySet()) {
            model.User user = userDAO.getById(userId);
            String nama = user != null ? user.getName() : "(tidak diketahui)";
            String nim = user != null ? user.getNim() : "-";
            System.out.println("\nAtas nama: " + nama + " (NIM: " + nim + ")");
            for (Absensi abs : grouped.get(userId)) {
                String tgl = abs.getTimestamp().toString().substring(0, 10); // yyyy-MM-dd
                System.out.println("  Tanggal " + tgl + ": " + abs.getStatus());
            }
        }
    }
}
