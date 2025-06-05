package view.admin;

import model.User;
import view.AdminView;

public class AdminKaryawanView extends AdminView {
    public AdminKaryawanView(User user, java.util.Scanner scanner) {
        super(user, scanner);
    }

    public void showKaryawanMenu() {
        boolean karyawanMenu = true;
        while (karyawanMenu) {
            System.out.println("\n=== Menu Kelola Karyawan ===");
            System.out.println("1. Ini Fitur karyawan nanti semuanya di menu ini");
            System.out.println("2. Kembali");
            System.out.print("Pilih menu (1/2): ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Ini Buat cek aja bisa apa gk");
                    break;
                case "2":
                    karyawanMenu = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
