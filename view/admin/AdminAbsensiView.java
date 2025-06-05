package view.admin;

import controller.AdminController;
import model.Absensi;
import java.util.List;
import model.User;
import view.AdminView;

public class AdminAbsensiView extends AdminView {
    private final AdminController adminController;

    public AdminAbsensiView(User user, java.util.Scanner scanner) {
        super(user, scanner);
        this.adminController = new AdminController();
    }

    public void showAbsensiMenu() {
        boolean absensiMenu = true;
        while (absensiMenu) {
            System.out.println("\n=== Menu Kelola Absensi ===");
            System.out.println("1. Tampilkan Semua Absensi");
            System.out.println("2. Cari Absensi (nama/status)");
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
            System.out.printf("ID: %d, User ID: %d, Tanggal: %s, Status: %s\n",
                data.getId(), data.getUserId(), data.getTanggal(), data.getStatus());
        }
    }

    private void showAllAbsensi() {
        List<Absensi> attendances = adminController.getAllAbsensi();
        printAbsensiList(attendances, "--- Semua Data Absensi (50 Terakhir) ---");
    }

    private void showLogAbsensi() {
        List<Absensi> log = adminController.getLastAbsensiLog();
        printAbsensiList(log, "--- Log Absensi Terakhir ---");
    }

    private void searchAbsensi(String keyword) {
        List<Absensi> results = adminController.searchAbsensi(keyword);
        printAbsensiList(results, "--- Hasil Pencarian Absensi ---");
    }
}
